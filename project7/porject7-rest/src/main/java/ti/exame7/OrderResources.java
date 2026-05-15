package ti.exame7;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/orders")
public class OrderResources {

    private static List<Order> orders = new ArrayList<>();
    private Gson gson = new Gson();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllOrders() {
        return gson.toJson(orders);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String createOrder(String body) {
        Order order = gson.fromJson(body, Order.class);
        Product found = null;
        for (Product p : ProductResources.products) {
            if (p.getId() == order.getProductId()) {
                found = p;
            }
        }

        if (found == null) {
            return "Product not found";
        }

        if (found.getStock() < order.getQuantity()) {
            return "Not enough stock";
        }

        found.setStock(found.getStock() - order.getQuantity());

        order.setTotalPrice(found.getPrice() * order.getQuantity());
        order.setStatus("pending");

        orders.add(order);
        return gson.toJson(order);
    }

    @PUT
    @Path("/{id}/status")
    @Produces(MediaType.APPLICATION_JSON)
    public String updateStatus(@PathParam("id") int id, @QueryParam("status") String status) {
        for (Order o : orders) {
            if (o.getId() == id) {
                o.setStatus(status);
                return gson.toJson(o);
            }
        }
        return "Order not found";
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteOrder(@PathParam("id") int id) {
        for (Order o : orders) {
            if (o.getId() == id) {
                for (Product p : ProductResources.products) {
                    if (p.getId() == o.getProductId()) {
                        p.setStock(p.getStock() + o.getQuantity());
                    }
                }
                orders.remove(o);
                return "Order cancelled, stock restored";
            }
        }
        return "Order not found";
    }
}