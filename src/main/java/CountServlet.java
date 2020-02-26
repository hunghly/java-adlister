import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (name = "CountServlet", urlPatterns = {"/count", "/counter?reset="})
public class CountServlet extends HttpServlet {
    public static int counter = 0;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String reset = req.getParameter("reset");
        if (reset == null) {
            CountServlet.counter++;
            out.println("Your current view counter: " + CountServlet.counter);
        } else if (reset.equals("true")) {
            CountServlet.counter = 0;
            out.println("The counter was reset!");
        }
    }
}
