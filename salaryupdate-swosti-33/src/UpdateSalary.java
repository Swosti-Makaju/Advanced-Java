//14.Write a java program update salary by 15% wholes salary less than 20000 from given table student(Id,Name,Salary,Gender) using JDBC.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateSalary {
    public static void main(String[] args) {
        try {
            // Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to Database  (change database name, user & password if needed)
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/swastik?useSSL=false",
                    "root",
                    ""
            );

            // SQL to update salary
            String sql = "UPDATE student SET salary = salary + (salary * 0.15) WHERE salary < 20000";

            PreparedStatement ps = con.prepareStatement(sql);

            int rows = ps.executeUpdate(); // execute update

            System.out.println(rows + " record(s) updated successfully!");

            con.close();   // close connection

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
