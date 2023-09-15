package mysqltutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mysqltutorial.org
 */
public class MySQLJDBCUtil {

    /**
     * Get database connection
     *
     * @return a Connection object
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        
    	Connection conn = null;

        try {
            
        	// db parameters
            String url       = "jdbc:mysql://localhost:3306/mysqljdbc";
            String user      = "root";
            String password  = "Aa123456";
        	
            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);

        } catch(SQLException e) {
           System.out.println(e.getMessage());
        }
        
        return conn;
        
    }
}
