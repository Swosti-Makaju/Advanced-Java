//15.Write a Java program using JDBC to connect to a MySQL database, create a table named tblStudent with columns id, name, and email, and insert a record into the table using a prepared statement.

import java.sql.*;

public class JDBCExample {
    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/swastik?useSSL=false",
            "root", ""
        );

        con.createStatement().execute(
            "CREATE TABLE IF NOT EXISTS tblStudent (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(50), email VARCHAR(50))"
        );

        PreparedStatement ps = con.prepareStatement("INSERT INTO tblStudent (name, email) VALUES (?, ?)");
        ps.setString(1, "Rahul");
        ps.setString(2, "rahul@example.com");
        ps.executeUpdate();

        ps.close();
        con.close();
    }
}
