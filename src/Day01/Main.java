package Day01;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/day01";
        String user = "root";
        String password = "maras46";
        String sql = "SELECT * FROM sirket;";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Bağlantı başarılı");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver bulunamadı"+e);
        }

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();
//            PreparedStatement pstmt=con.prepareStatement("INSERT INTO sirket values(101,'Honda');");
//            con.prepareStatement("INSERT INTO sirket values(102,'Ford');").executeUpdate();
//            con.prepareStatement("INSERT INTO sirket values(101,'Hyundai');").executeUpdate();
//            pstmt.executeUpdate();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println();
                System.out.println(rs.getInt(1)+" \t "+rs.getString(2));
            }
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        /*
        try {
            String url = "jdbc:mysql://localhost:3306/day01";
            String user = "root";
            String password = "maras46";
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();

            String isim = "'Honda'";
            String sqlStatement = "delete from sirket where sirket_isim =" + isim;
            int result = stmt.executeUpdate(sqlStatement);
            System.out.println(result + " kayit silindi!");

            int result1 = stmt.executeUpdate("update sirket set sirket_isim = 'Anadol' where sirket_isim = 'Ford'");
            System.out.println(result1 + " kayit güncellendi!");

            int result2 = stmt.executeUpdate("insert into sirket values(105, 'Opel')");
            System.out.println(result2 + " kayit eklendi!");
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }*/
    }

}

