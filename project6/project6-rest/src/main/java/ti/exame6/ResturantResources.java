package ti.exame6;

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

@Path("/orders")
public class ResturantResources {
  private static List<Resturant> resturants = new ArrayList<>();
  private Gson gson = new Gson();

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String getAllOrders(){
    return gson.toJson(resturants);
  }

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public String getOrderById(@PathParam("id")int id){
    for(Resturant r : resturants){
      if(r.getId() == id){
        return gson.toJson(r);
      }
    }
    return "Order not found";
  }

  public String searchOrderByStatus(@QueryParam("status") String status) {
      List<Resturant> results = new ArrayList<>();
      for (Resturant r : resturants) {
          if (r.getStatus().equals(status)) {
              results.add(r);
          }
      }
      return gson.toJson(results);
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public String createOrder(String body) {
    Resturant resturant = gson.fromJson(body, Resturant.class);
    resturant.setStatus("pending");    
    resturants.add(resturant);
    return gson.toJson(resturant);
  }


  @PUT
  @Path("/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public String updateOrder(@PathParam("id")int id){
    for(Resturant r : resturants){
      if(r.getId() == id){
        return "Order updated successfully";
      }
    }
    return "Order not found";
  }

  @PUT
  @Path("/{id}/status")
  @Produces(MediaType.APPLICATION_JSON)
  public String updateOrderStatus(@PathParam("id") int id, @QueryParam("status") String status) {
      for (Resturant r : resturants) {
          if (r.getId() == id) {
              r.setStatus(status);
              return gson.toJson(r);
          }
      }
      return "Order not found";
  }

  @DELETE
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public String removeOrder(@PathParam("id")int id){
    for(Resturant r : resturants){
      if(r.getId() == id){
        resturants.remove(r);
        return "Order removed successfully";
      }
    }
    return "Order not found";
  }
}
