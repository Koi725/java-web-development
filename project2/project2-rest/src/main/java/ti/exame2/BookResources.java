package ti.exame2;

import java.util.ArrayList;
import java.util.List;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;
import com.google.gson.Gson;

@Path("/books")
public class BookResources {

    private static List<Book> books = new ArrayList<>();
    private static Gson gson = new Gson();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll() {
        return gson.toJson(books);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addBook(String body) {
        Book book = gson.fromJson(body, Book.class);
        books.add(book);
        return gson.toJson(book);
    }
}