<%@ page import="java.sql.*" %>
<%
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String address = request.getParameter("address");

    try {
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/lab?useSSL=false",
            "root",
            "root"
        );

        String sql = "INSERT INTO user(name, email, address) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, name);
        ps.setString(2, email);
        ps.setString(3, address);

        ps.executeUpdate();

        out.println("<h3>Data Stored Successfully!</h3>");

        ps.close();
        con.close();

    } catch(Exception e) {
        out.println("Error: " + e.getMessage());
    }
%>
