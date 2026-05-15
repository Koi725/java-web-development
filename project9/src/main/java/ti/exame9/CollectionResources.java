package ti.exame9;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/collections")
public class CollectionResources {
    private Gson gson = new Gson();
    private static List<Collection> collections = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllCollections(){
      return gson.toJson(collections);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addCollection(String body){
      Collection collection = gson.fromJson(body, Collection.class);
      collections.add(collection);
      return gson.toJson(collection);
    }

    @DELETE
    @Path("/{collection}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteCollection(@PathParam("collection")String collection){
      for(Collection c :collections){
        if(c.getName().equals(collection)){
          collections.remove(c);
          return gson.toJson("Collection deleted successfully");
        }
      }
      return gson.toJson("Collection not found");
    }

    @PUT
    @Path("/{title}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateCollection(@PathParam("title") String title, String body) {
        Collection updated = gson.fromJson(body, Collection.class);
        for (int i = 0; i < collections.size(); i++) {
            if (collections.get(i).getName().equalsIgnoreCase(title)) {
                collections.set(i, updated);
                return gson.toJson(updated);
            }
        }
        return "Collection not found";
    } 
}