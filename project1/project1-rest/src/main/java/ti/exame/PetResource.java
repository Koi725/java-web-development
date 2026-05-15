package ti.exame;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;        // ← was missing

@Path("/pets")
public class PetResource {                  // ← no underscores, capital P R

    private static List<Pet> pets = new ArrayList<>();  // ← capital Pet
    private static Gson gson = new Gson();

    static {
        pets.add(new Pet("Rex", 5,123456789,"Dog"));      // ← order fixed, NIF as String
        pets.add(new Pet("Whiskers", 3,987654321,"Cat"));
        pets.add(new Pet("Buddy", 2,555555555,"Dog"));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll() {
        return gson.toJson(pets);
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByName(@PathParam("name") String name) {  // ← one (, Response not String
        for (Pet p : pets) {                                      // ← capital Pet
            if (p.getName().equalsIgnoreCase(name)) {
                return Response.ok(gson.toJson(p)).build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(String body){
        Pet newPet = gson.fromJson(body,Pet.class);
        pets.add(newPet);
        return Response.status(Response.Status.CREATED).entity(gson.toJson(newPet)).build();
    }

    @DELETE
    @Path("/{name}")
    public Response delete(@PathParam("name") String name) {
        boolean removed = pets.removeIf(p -> p.getName().equalsIgnoreCase(name));  // ← capital Pet
        if (removed) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }   
    }
}