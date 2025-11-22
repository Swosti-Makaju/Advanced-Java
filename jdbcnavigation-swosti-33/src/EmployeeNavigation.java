//16.Write a Java program using JDBC to connect to a MySQL database and display employee details from the emp table. The program should demonstrate how to move through the result set using navigation methods such as first(), last(), previous(), and next(), and print the corresponding employee records on the console.

import java.sql.*;

public class EmployeeNavigation {
    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/swastik?useSSL=false",
                "root",
                ""
        );

        Statement stmt = con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
        );

        ResultSet rs = stmt.executeQuery("SELECT * FROM emp");

        if (rs.first())
            System.out.println("First Employee: " + rs.getInt("id") + "\t" + rs.getString("name") + "\t" + rs.getString("department"));

        if (rs.last())
            System.out.println("Last Employee: " + rs.getInt("id") + "\t" + rs.getString("name") + "\t" + rs.getString("department"));

        if (rs.previous())
            System.out.println("Previous Employee: " + rs.getInt("id") + "\t" + rs.getString("name") + "\t" + rs.getString("department"));

        if (rs.next())
            System.out.println("Next Employee: " + rs.getInt("id") + "\t" + rs.getString("name") + "\t" + rs.getString("department"));

        rs.close();
        stmt.close();
        con.close();
    }
}
