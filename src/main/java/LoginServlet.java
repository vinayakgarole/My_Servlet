import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        description = "Login Servlet Testing",
        urlPatterns = {"/LoginServlet"},
        initParams = {
                @WebInitParam(name = "user", value = "Vinayak"),
                @WebInitParam(name = "password", value = "Vinayak123")
        }
)

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get request for userID and Password
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");
        //get servlet config init params
        String userID = getServletConfig().getInitParameter("user");
        String password = getServletConfig().getInitParameter("password");
        //regex for username and password
        String userRegex = "^[A-Z]{1}.{2,}$"; //username regex
        /*
        Checking for
        1. User name regex
        2. Atleast one upper case
        3. Min 3 characters 
         */
        if (!user.matches(userRegex)) {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/Login.html");
            PrintWriter out = response.getWriter();
            out.println("<font color=red>Incorrect User, Enter the Correct user name</font>");
            requestDispatcher.include(request, response);
        }
        if (userID.equals(user) && password.equals(pwd)) {
            request.setAttribute("user", user);
            request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);
        } else {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/Login.html");
            PrintWriter out = response.getWriter();
            out.println("<font color=red> Either user name or password is wrong.</font>");
            requestDispatcher.include(request, response);
        }
    }
}