import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/home")
public class ServletA extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String firstName=req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        if(!firstName.isEmpty()&& !lastName.isEmpty()){
            RequestDispatcher rd=req.getRequestDispatcher("Hello");
            rd.forward(req, resp);

        }
        else{
            out.print("Fill both fields");
            RequestDispatcher rd=req.getRequestDispatcher("index.html");
            rd.include(req, resp);
        }
    }
}