package mysqltutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class executeUpdateStatement {

	public executeUpdateStatement() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try{
			String url       = "jdbc:mysql://localhost:3306/day01";
			String user      = "root";
			String password  = "maras46";



			Connection con = DriverManager.getConnection(url, user, password);	

			Statement stmt = con.createStatement();
			
			
			/*
			String isim = "'Opel 2'";
			String sqlStatement = "delete from sirket where sirket_isim =" + isim;			
			
			
			int result = stmt.executeUpdate(sqlStatement);
			
			System.out.println(result + " kayit silindi!");
			*/

			
			/*
			int result = stmt.executeUpdate("update sirket set sirket_isim = 'Opel 2' where sirket_isim = 'Opel'");
			
			System.out.println(result + " kayit guncellendi!");
			*/		
			
			
			int result = stmt.executeUpdate("insert into sirket values(108, 'Opel')");

			System.out.println(result + " kayit eklendi!");
				

			con.close();

		} catch(SQLException e) { System.out.println(e); }

	}

}