package Day01;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        DbaseHelper dbaseHelper= new DbaseHelper();
        dbaseHelper.dbaseConnect();

//        String sql = "SELECT sirket_id, sirket_isim FROM sirket order by sirket_id";
//
//        try {
//
//            ResultSet rs    = dbaseHelper.stmt.executeQuery(sql);
//
//            while (rs.next()) {
//                System.out.println(rs.getInt("sirket_id") + "\t" + rs.getString("sirket_isim"));
//            }
//            dbaseHelper.conn.close();
//
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }


        try {
            String url = "jdbc:mysql://localhost:3306/day01";
            String user = "root";
            String password = "maras46";
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();

            String sqlStatement = "delete from sirket where sirket_isim = 'Honda'" ;
            int result = stmt.executeUpdate(sqlStatement);

            System.out.println(result + " kayit silindi!");

            int result1 = stmt.executeUpdate("update sirket set sirket_isim = 'Anadol' ");
            System.out.println(result1 + " kayit güncellendi!");

            int result2 = stmt.executeUpdate("insert into sirket values(105, 'Opel')");
            System.out.println(result2 + " kayit eklendi!");
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}

