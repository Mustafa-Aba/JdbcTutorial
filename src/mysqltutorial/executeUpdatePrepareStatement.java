package mysqltutorial;

import java.sql.*;

class executeUpdatePrepareStatement{

	public static void main(String args[]){
		try{

			String url       = "jdbc:mysql://localhost:3306/day01";
			String user      = "root";
			String password  = "maras46";


			Connection con = DriverManager.getConnection(url, user, password);
			

			PreparedStatement pstmt = con.prepareStatement("delete from sirket where sirket_id = ? and sirket_isim = ? ");

			pstmt.setInt(1, 105);

			pstmt.setString(2, "Anadol");

			int i = pstmt.executeUpdate();

			System.out.println(i + " kayit silindi!");

			/*
			PreparedStatement pstmt = con.prepareStatement("update sirket set sirket_isim = ? where sirket_id = ?");
			
			pstmt.setString(1, "Opel");
			
			pstmt.setInt(2, 104);			

			int i = pstmt.executeUpdate();// etkilenen satır sayısını döndürür.return eder
			
			System.out.println(i + " kayit guncellendi!");
			*/
			
			
//			PreparedStatement pstmt = con.prepareStatement("insert into sirket (sirket_id, sirket_isim) values(?, ?)");
//
//			pstmt.setInt(1, 105);
//			pstmt.setString(2, "Toyota");
//
//			int i = pstmt.executeUpdate();
//
//			System.out.println(i + " kayit eklendi!");
			

			con.close();

		} catch(Exception e) { System.out.println(e); }

	}
}