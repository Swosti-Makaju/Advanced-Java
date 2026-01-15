import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/InsertServlet")
public class SaveUser extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        try {
            // Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create Connection
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/lab?useSSL=false&serverTimezone=UTC",
                "root",
                "root"
            );

            // SQL Insert Query
            String sql = "INSERT INTO user(name, email, address) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, address);

            int result = ps.executeUpdate();

            if (result > 0) {
                out.println("<h3>Data inserted successfully!</h3>");
            } else {
                out.println("<h3>Data insertion failed.</h3>");
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}