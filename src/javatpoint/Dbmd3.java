package javatpoint;

import java.sql.*;

class Dbmd3{

	public static void main(String args[]){

		try{

			//db parameters
			String url       = "jdbc:mysql://localhost:3306/fsae01";
			String user      = "root";
			String password  = "Aa123456";			

			//Class.forName("com.mysql.cj.jdbc.Driver");

			//create a connection to the database
			Connection con = DriverManager.getConnection(url, user, password);

			DatabaseMetaData dbmd = con.getMetaData();
			
			String table[]={"VIEW"};
			
			ResultSet rs=dbmd.getTables(null,null,null,table);

			while(rs.next()){
				System.out.println(rs.getString(1) + " " + rs.getString(3) + " " + rs.getString(4));
			}

			con.close();

		}catch(Exception e){ System.out.println(e);}

	}
}