package ti.exame2;

import org.eclipse.jetty.servlet.ServletContextHandler;

import jakarta.servlet.ServletContext;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main{
    public static void main(String[] args) {
      ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
      context.setContextPath("/");

      Server jetty = new Server(8001);
      jetty.setHandler(context);

      ServletHolder jerestServlet = context.addServlet(org.glassfish.jersey.servlet.ServletContainer.class, "/*");

      jerestServlet.setInitParameter("jersey.config.server.provider.classnames",BookResources.class.getCanonicalName());

      try{
        jetty.start();
        jetty.join();
      }catch(Exception e){
        e.printStackTrace();
      }
    }
}
