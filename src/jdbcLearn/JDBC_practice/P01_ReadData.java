package jdbcLearn.JDBC_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class P01_ReadData {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/javacan";// mysql bağlantı  adresi(path) tanımlandı
        String username = "root";// mysql bağlantı için username   tanımlandı
        String password = "maras46";// mysql bağlantı için password   tanımlandı

        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();

        // Task01-> talebeler table'daki record'ları listeleyen code create ediniz
        System.out.println("***Task01***\n");
        ResultSet rs = statement.executeQuery("SELECT * FROM talebeler");

        while (rs.next()) {
            System.out.printf("%-6d  %-20.20s %-8s %-6d\n",
                    rs.getInt(1), rs.getString(2),
                    rs.getString(3), rs.getInt(4));
        }

        // Task02-> talebeler table'daki notları 90 dan yuksek olan record'ları listeleyen code create ediniz
        System.out.println("***Task02***\n");
        ResultSet not90ustu = statement.executeQuery("SELECT * FROM talebeler where yazili_notu>90");

        while (not90ustu.next()) {
            System.out.printf("%-6d  %-20.20s %-8s %-6d\n",
                    not90ustu.getInt(1), not90ustu.getString(2),
                    not90ustu.getString(3), not90ustu.getInt(4));
        }
        System.out.println("***Task03***\n");
        // Task03-> talebeler table'daki id değeri 124 olan record'ları listeleyen code create ediniz
        ResultSet id124 = statement.executeQuery("select * from talebeler where id=124");
        while (id124.next()) {
            System.out.printf("%-6d   %-20.20s  %-8s %-6d\n", id124.getInt(1), id124.getString(2),
                    id124.getString(3), id124.getInt(4));
        }
        System.out.println("***Task04***\n");
        // Task04-> talebeler table'daki notu 70 ile 90 arasında  olan record'ları listeleyen code create ediniz
        ResultSet not70ile90 = statement.executeQuery("select * from talebeler where yazili_notu between 70 and 90");
        while (not70ile90.next()) {
            System.out.printf("%-6d   %-20.20s  %-8s %-6d\n", not70ile90.getInt(1), not70ile90.getString(2),
                    not70ile90.getString(3), not70ile90.getInt(4));
        }
        System.out.println("***Task05***\n");
        // Task05-> talebeler table'daki 3. harfi "l"  olan record'ları listeleyen code create ediniz
        ResultSet ucuncuHarfL = statement.executeQuery("select * from talebeler where isim like '__l%'");
        while (ucuncuHarfL.next()) {
            System.out.printf("%-6d   %-20.20s  %-8s %-6d\n", ucuncuHarfL.getInt(1), ucuncuHarfL.getString(2),
                    ucuncuHarfL.getString(3), ucuncuHarfL.getInt(4));
        }
        connection.close();


    }
}
