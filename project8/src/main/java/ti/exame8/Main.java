package ti.exame8;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Member Resources...");

        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        handler.setContextPath("/");

        Server jetty =new Server(8001);
        jetty.setHandler(handler);

        ServletHolder jerseyServlet = handler.addServlet(org.glassfish.jersey.servlet.ServletContainer.class, "/*");
        jerseyServlet.setInitParameter("jersey.config.server.provider.classnames", MemberResources.class.getCanonicalName());

        try{
          jetty.start();
          jetty.join();
        } catch (Exception e) {
          e.printStackTrace();  
        }
    }
}