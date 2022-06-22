import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class Servlet extends HttpServlet {  
public void doGet(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
          
        out.print("welcome ADMIN");  
        out.close();  
    }  
}  