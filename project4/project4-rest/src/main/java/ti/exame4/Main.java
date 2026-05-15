package ti.exame4;

import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.server.Server;

public class Main {
  public static void main(String[] args) {
    Car car1 = new Car("Toyota", "Corolla", 2020, 20000);
    Car car2 = new Car("Honda", "Civic", 2019, 22.500);
    Car car3 = new Car("Ford", "Mustang", 2021, 30000);

    ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
    context.setContextPath("/");

    Server server = new Server(8001);
    server.setHandler(context);

    ServletHolder jerseyServlet = context.addServlet(org.glassfish.jersey.servlet.ServletContainer.class, "/*");
    jerseyServlet.setInitParameter("jersey.config.server.provider.classnames", CarResources.class.getCanonicalName());
    try {
      server.start();
      server.join();
    } catch (Exception e) {
      e.printStackTrace();
    }
  } 
}
