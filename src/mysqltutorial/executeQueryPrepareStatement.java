package mysqltutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mysqltutorial.org
 */
public class executeQueryPrepareStatement {
    
    public static void main(String[] args) {       
  	    
    	
        String url       = "jdbc:mysql://localhost:3306/day01";
        String user      = "root";
        String password  = "maras46";
    	 
        String sql = "SELECT sirket_id, sirket_isim FROM sirket where sirket_id = ?"; // ? işareti yerine 103 pstmt.setInt(1,103)
        

		try {      	
        	
        	 Connection con = DriverManager.getConnection(url, user, password);        	
             
			 PreparedStatement  pstmt = con.prepareStatement(sql);// parametreli statement return eder
				
			 pstmt.setInt(1, 102);
				
			 ResultSet rs    = pstmt.executeQuery();
           
            while (rs.next()) {
                System.out.println(rs.getInt("sirket_id") + "\t" + rs.getString("sirket_isim"));                    
            }
            
            con.close();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }      

    }
        
}