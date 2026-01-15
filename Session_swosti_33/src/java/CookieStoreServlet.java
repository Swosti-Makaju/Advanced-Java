import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/CookieStoreServlet")
public class CookieStoreServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Cookie userCookie = new Cookie("username", username);
        Cookie passCookie = new Cookie("password", password);

        userCookie.setMaxAge(24 * 60 * 60);
        passCookie.setMaxAge(24 * 60 * 60);

        response.addCookie(userCookie);
        response.addCookie(passCookie);

        response.sendRedirect("CookieRetrieveServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
