import java.sql.*; 
 
public class DeleteRecord { 
    public static void main(String[] args) { 
        try { 
            Connection con = DriverManager.getConnection( 
                "jdbc:mysql://localhost:3306/yourDB", "root", "password"); 
            PreparedStatement ps = con.prepareStatement( 
                "DELETE FROM your_table WHERE id = ?"); 
            ps.setInt(1, 101); 
            ps.executeUpdate(); 
            System.out.println("Record deleted"); 
            con.close(); 
        } catch (Exception e) { 
            System.out.println(e); 
        } 
    } 
} 
