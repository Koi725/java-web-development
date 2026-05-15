package ti.exam3;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {
  public static void main(String[] args) {
    ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
    context.setContextPath("/");


    Server server = new Server(8001);
    server.setHandler(context);

    ServletHolder jersHolder = context.addServlet(org.glassfish.jersey.servlet.ServletContainer.class, "/*");
    jersHolder.setInitParameter("jersey.config.server.provider.classnames",MusicResources.class.getCanonicalName());

    try {
      server.start();
      server.join();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      server.destroy();
    }
  }
}
