//Sending response by filter only

import java.io.*;  
import javax.servlet.*;  
  
public class Filter_1 implements Filter{  
    public void init(FilterConfig arg0) throws ServletException {}  
  
    public void doFilter(ServletRequest req, ServletResponse res,  
            FilterChain chain) throws IOException, ServletException {  
      
        PrintWriter out=res.getWriter();  
          
        out.print("<br/>this site is underconstruction..");  
        out.close();  
          
    }  
    public void destroy() {}  
}  