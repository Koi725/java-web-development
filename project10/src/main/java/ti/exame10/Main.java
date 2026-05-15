package ti.exame10;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {
  public static void main(String[] args) {
    ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
    context.setContextPath("/");


    Server jetty = new Server(8001);
    jetty.setHandler(context);

    ServletHolder holder = context.addServlet(org.glassfish.jersey.servlet.ServletContainer.class, "/*");
    holder.setInitParameter("jersey.config.server.provider.classnames", RoomResources.class.getCanonicalName());

    try {
      jetty.start();
      jetty.join();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
