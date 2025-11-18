import java.sql.*; 
 
public class InsertRecord { 
    public static void main(String[] args) { 
        try { 
            Connection con = DriverManager.getConnection( 
                "jdbc:mysql://localhost:3306/yourDB", "root", "password"); 
            PreparedStatement ps = con.prepareStatement( 
                "INSERT INTO your_table (id, name) VALUES (?, ?)"); 
            ps.setInt(1, 101); 
            ps.setString(2, "Alice"); 
            ps.executeUpdate(); 
            System.out.println("Record inserted"); 
            con.close(); 
        } catch (Exception e) { 
            System.out.println(e); 
        } 
    } 
} 
