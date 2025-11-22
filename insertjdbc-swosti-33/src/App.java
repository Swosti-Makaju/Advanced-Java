
//13.Write a java program to inset 5 student records and display record in name ascending order, given table student(Id,Name,Gender,Address) using JDBC.
import java.sql.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement psInsert = null;
        Statement stmt = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);

        try {
            // Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Database Connection
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studentdb?useSSL=false",
                "root",
                ""
            );

            // Insert SQL
            String insertSql = "INSERT INTO student(name, gender, address) VALUES (?, ?, ?)";
            psInsert = con.prepareStatement(insertSql);

            System.out.println("Enter details for 5 students:");

            for(int i = 1; i <= 5; i++) {
                System.out.println("\nStudent " + i + ":");

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Gender: ");
                String gender = sc.nextLine();

                System.out.print("Address: ");
                String address = sc.nextLine();

                psInsert.setString(1, name);
                psInsert.setString(2, gender);
                psInsert.setString(3, address);
                psInsert.executeUpdate();
            }

            System.out.println("\n✅ Records Inserted Successfully!\n");

            // Display Records in Ascending Order by Name
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM student ORDER BY name ASC");

            System.out.println("---- Student Records (Sorted by Name) ----");
            while(rs.next()) {
                System.out.println(
                        rs.getInt("id") + "\t"
                        + rs.getString("name") + "\t"
                        + rs.getString("gender") + "\t"
                        + rs.getString("address")
                );
            }

        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try { con.close(); } catch(Exception ignored) {}
            sc.close();
        }
    }
}
