package ti.exame5;

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
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/patients")
public class PatientResources {
  private static List<Patient> patients = new ArrayList<>();
  private Gson gson = new Gson();

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String getAllPatient(){
    return gson.toJson(patients);
  }

  @GET
  @Path("/{name}")
  @Produces(MediaType.APPLICATION_JSON)
  public String getPatientByName(@PathParam("name")String name){
    for(Patient patient : patients){
      if(patient.getName().equals(name)){
        return gson.toJson(patient);
      }
    }
    return gson.toJson(null);
  }

  @GET
  @Path("/search")
  @Produces(MediaType.APPLICATION_JSON)
  public String getPatientsByDoctorName(@QueryParam("doctor") String doctorName) {
      List<Patient> results = new ArrayList<>();
      for (Patient patient : patients) {
          if (patient.getDoctorName().equals(doctorName)) {
              results.add(patient);
          }
      }
      return gson.toJson(results);
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public String addPatient(String patientJson){
    Patient patient = gson.fromJson(patientJson, Patient.class);
    patients.add(patient);
    return gson.toJson(patient);
  }

  @DELETE
  @Path("/{name}")
  @Produces(MediaType.APPLICATION_JSON)
  public String deletePatient(@PathParam("name")String name){
    for(Patient patient : patients){
      if(patient.getName().equals(name)){
        patients.remove(patient);
        return gson.toJson(patient);
      }
    }
    return gson.toJson(null);
  }

}