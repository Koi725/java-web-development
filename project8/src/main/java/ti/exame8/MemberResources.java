package ti.exame8;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/members")
public class MemberResources {

    private static List<Members> members = new ArrayList<>();
    private Gson gson = new Gson();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getMembers() {
        return gson.toJson(members);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addMember(String body) {
        Members member = gson.fromJson(body, Members.class);
        members.add(member);
        return gson.toJson(member);
    }

    @DELETE
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteMember(@PathParam("name") String name) {
        for (Members m : members) {
            if (m.getName().equals(name)) {
                members.remove(m);
                return "Member deleted";
            }
        }
        return "Member not found";
    }
}