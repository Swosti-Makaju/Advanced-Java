//17.Write a Java program using JDBC to connect to a MySQL database and retrieve an employee record from the emp table based on a given ID using a prepared statement. The program should use an updatable ResultSet to modify the employee’s name and update the record in the database.

import java.sql.*;
import java.util.Scanner;

public class UpdateEmployee {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee ID to update: ");
        int empId = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter new Employee Name: ");
        String newName = sc.nextLine();

        // 1. Connect to Database
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/swastik?useSSL=false",
                "root",
                "");

        // 2. Create PreparedStatement with scrollable, updatable ResultSet
        PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM emp WHERE id = ?",
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);

        ps.setInt(1, empId);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            System.out.println("Current Employee: " + rs.getInt("id") + "\t" + rs.getString("name") + "\t"
                    + rs.getString("department"));

            // Update name
            rs.updateString("name", newName);
            rs.updateRow();

            System.out.println("Employee name updated successfully.");
        } else {
            System.out.println("Employee with ID " + empId + " not found.");
        }

        // Close resources
        rs.close();
        ps.close();
        con.close();
        sc.close();
    }
}
