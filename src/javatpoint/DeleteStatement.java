package javatpoint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteStatement {

	public DeleteStatement() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try{			

			// db parameters
			String url       = "jdbc:mysql://localhost:3306/fsae01";
			String user      = "root";
			String password  = "Aa123456";			

			// Class.forName("com.mysql.cj.jdbc.Driver");

			// create a connection to the database
			Connection con = DriverManager.getConnection(url, user, password);	

			Statement stmt = con.createStatement();

			/*
			String isim = "'Yavuz Bal'";
			String sqlStatement = "delete from ogrenciler where isim =" + isim;	

			int result = stmt.executeUpdate(sqlStatement);
			*/

			/*
			int result = stmt.executeUpdate("update ogrenciler set isim = 'Martin Parr2' where id = 121");
			*/
			
			int result = stmt.executeUpdate("insert into ogrenciler values(221, 'Ali Veli2', 'Ankara', 95)");			

			System.out.println(result + " records affected");			

			con.close();

		}catch(SQLException e){ System.out.println(e);}

	}

}