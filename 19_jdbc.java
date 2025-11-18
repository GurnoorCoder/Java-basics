import java.sql.*; 
 
public class DisplayRecords { 
    public static void main(String[] args) { 
        try { 
            Connection con = DriverManager.getConnection( 
                "jdbc:mysql://localhost:3306/yourDB", "root", "password"); 
            Statement stmt = con.createStatement(); 
            ResultSet rs = stmt.executeQuery("SELECT * FROM your_table"); 
 
            while (rs.next()) { 
                System.out.println(rs.getInt(1) + " " + rs.getString(2)); 
            } 
 
            con.close(); 
        } catch (Exception e) { 
            System.out.println(e); 
        } 
    } 
} 
