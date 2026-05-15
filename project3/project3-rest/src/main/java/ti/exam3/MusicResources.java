package ti.exam3;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/music")
public class MusicResources {
    private static List<Music> musicList = new ArrayList<>();
    private Gson gson = new Gson();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll(){
      return gson.toJson(musicList);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addMusic(String musicJson){
      Music music = gson.fromJson(musicJson, Music.class);
      musicList.add(music);
      return gson.toJson(music);
    }

    @DELETE
    @Path("/{title}")
    public String deleteMusic(@PathParam("title")String title){
      for(Music music : musicList){
        if(music.getTitle().equals(title)){
          musicList.remove(music);
          return gson.toJson(music);
        }
      }
      return "Music not found";
    }
}