import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String mes = "IT worked";
        out.println("<HTML><BODY>");
        out.println("<H1>" + mes + "</H1>");
        out.println("</BODY></HTML>");
        out.close();
    }
}