package ti.exame10;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import jakarta.validation.constraints.PositiveOrZero;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/rooms")
public class RoomResources {
  private static Gson gson = new Gson();
  private static List<Room> rooms = new ArrayList<>();

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String getRooms(){
    return gson.toJson(rooms);
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public String addRoom(String body){
    Room room = gson.fromJson(body, Room.class);
    rooms.add(room);
    return gson.toJson(room);
  }

  @GET
  @Path("/{number}")
  @Produces(MediaType.APPLICATION_JSON)
  public String getRoomByNumber(@PathParam("number") @PositiveOrZero int number){
    for(Room room : rooms){
      if(room.getNumber() == number){
        return gson.toJson(room);
      }
    }
    return gson.toJson(null);
  }

  @GET
  @Path("/available")
  @Produces(MediaType.APPLICATION_JSON)
  public String getAvailableRoom(){
    for(Room room : rooms){
      if(room.isAvailable()){
        return gson.toJson(room);
      }
    }
    return gson.toJson(null);
  }

  @PUT
  @Path("/{number}/book")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public String bookRoom(@PathParam("number") @PositiveOrZero int number){
    for(Room room : rooms){
      if(room.getNumber() == number){
        room.setAvailable(false);
        return gson.toJson(room);
      }
    }
    return gson.toJson(null);
  }

  @PUT
  @Path("/{number}/release")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public String releaseRoom(@PathParam("number") @PositiveOrZero int number){
    for(Room room : rooms){
      if(room.getNumber() == number){
        room.setAvailable(true);
        return gson.toJson(room); 
      }
    }
    return gson.toJson(null);
  } 
}
