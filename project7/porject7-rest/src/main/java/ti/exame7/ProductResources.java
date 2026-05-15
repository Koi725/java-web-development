package ti.exame7;

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
import jakarta.ws.rs.core.Response;

@Path("/products")
public class ProductResources {
  public static List<Product> products = new ArrayList<>();
  private Gson gson = new Gson();

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getProducts() {
    return Response.ok(gson.toJson(products)).build();
  }

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public String getProductById(@PathParam("id")int id){
    for(Product p : products){
      if(p.getId() == id){
        return gson.toJson(p);
      }
    }
    return "Product not found";
  }


  @GET
  @Path("/category/{category}")
  @Produces(MediaType.APPLICATION_JSON)
  public String getProductsByCategory(@QueryParam("category")String category){
    for(Product p : products){
      if(p.getCategory().equalsIgnoreCase(category)){
        return gson.toJson(p);
      }
    }
    return "No products found in this category";
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public String addProduct(String productJson){
    Product p = gson.fromJson(productJson, Product.class);
    products.add(p);
    return gson.toJson(p);
  }

  @PUT
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public String updateProduct(@PathParam("id")int id, String productJson){
    Product updateProduct = gson.fromJson(productJson, Product.class);
    for(Product p : products){
      if(p.getId() == id){
        p.setName(updateProduct.getName());
        p.setCategory(updateProduct.getCategory());
        p.setPrice(updateProduct.getPrice());
        p.setStock(updateProduct.getStock());
        return gson.toJson(p);
      }
    }
    return "Product not found";
  }

  @DELETE
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public String deleteProduct(@PathParam("id")int id){
    for(Product p : products){
      if(p.getId() == id){
        products.remove(p);
        return "Product deleted successfully";
      }
    }
    return "Product not found";
  }
}
