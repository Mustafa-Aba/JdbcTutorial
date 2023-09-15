package mysqltutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mysqltutorial.org
 */
public class executeQueryStatement {
    
    public static void main(String[] args) {       
  	    
    	
        String url       = "jdbc:mysql://localhost:3306/fsae03";
        String user      = "root";
        String password  = "Aa123456";
    	 
        String sql = "SELECT sirket_id, sirket_isim FROM sirket order by sirket_id";
        
        try {        	
        	
        	 Connection con = DriverManager.getConnection(url, user, password);        	
             Statement stmt  = con.createStatement();
             ResultSet rs    = stmt.executeQuery(sql);// ResultSet data type nda nesne üretir
           
            while (rs.next()) {
                System.out.println(rs.getInt("sirket_id") + "\t" + rs.getString("sirket_isim"));                    
            }
            
            con.close();//bağlantı kapanır
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }      

    }
        
}