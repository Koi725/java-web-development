package ti.exame4;

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
import jakarta.ws.rs.core.MediaType;

@Path("/cars")
public class CarResources {
    private static List<Car> cars = new ArrayList<>();
    private Gson gson = new Gson();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCars() {
        return gson.toJson(cars);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addCar(String carJson) {
        Car car = gson.fromJson(carJson, Car.class);
        cars.add(car);
        return gson.toJson(car);
    } 

    @DELETE
    @Path("/{model}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteCar(@PathParam("model") String model) {
      for (Car car :cars){
        if(car.getModel().equals(model)){
          cars.remove(car);
          return gson.toJson(car);
        }
      }
      return gson.toJson("Car not found");
    }


    @PUT
    @Path("/{model}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateCar(@PathParam("model") String model, String carJson) {
        Car updatedCar = gson.fromJson(carJson, Car.class);
        for (Car car : cars) {
            if (car.getModel().equals(model)) {
                car.setBrand(updatedCar.getBrand());
                car.setYear(updatedCar.getYear());
                car.setPrice(updatedCar.getPrice());
                break;
            }
        }
        return gson.toJson(updatedCar);
    }
  }