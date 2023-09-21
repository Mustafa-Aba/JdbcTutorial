package jdbcLearn.JDBC_practice;

import java.sql.*;


public class P02_ReadDataDifferent {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/javacan";// mysql bağlantı  adresi(path) tanımlandı
        String username = "root";// mysql bağlantı için username   tanımlandı
        String password = "maras46";// mysql bağlantı için password   tanımlandı

        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        // rs resultest'i cursoru scroll'a duyarsız sadece read yapma tanımlandı.--> ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY
        // bu parametre statement'e tanımlanmzasa default olarak cursor(-1) imleç iterator tanımlar...

        ResultSet rs = statement.executeQuery("SELECT * FROM personel");
        System.out.println("   *** task01 ***     ");
        // task01-> ilk satırdaki ilk obj print eden code create ediniz.

        System.out.println("rs.getRow() = " + rs.getRow());//iterator ın bulunduğu satırı getirir
        System.out.println("rs.first() = " + rs.first());//iterator ilk satıra gelir return boolean
        System.out.println("rs.getRow() = " + rs.getRow());//iterator ın bulunduğu satırı getirir

        System.out.println("ilk satır ilk eleman: " + rs.getObject(1));// ilk satır ilk eleman
        System.out.println("rs.getObject(5) = " + rs.getObject(5));//ilk satır 5. eleman

        System.out.println("   *** task02 ***     ");
        // task02->ilk sutundaki 5.degeri yazdiralim: 5 satırın ilk değeri
        System.out.println("rs.absolute(5) = " + rs.absolute(5));// Beşinci satıra gitmek için kullanılır. return boolean
        System.out.println("rs.getObject(1) = " + rs.getObject(1).toString());


        System.out.println("   *** task03 ***     ");

        // task03->tum id listeyi print eden code create ediniz.
        System.out.println(rs.absolute(0));// 0. satıra gitmek için kullanılır.
        while (rs.next()) {
            // System.out.println( rs.getObject("id").toString());
            System.out.println(rs.getObject(1).toString());
        }


        System.out.println("   *** task04 ***     ");

        // task04->tum isim listeyi print eden code create ediniz.
        rs.absolute(0);
        while (rs.next()) {
            System.out.println(rs.getObject("isim").toString());
        }

        System.out.println("   *** task05 ***     ");

        // task05->tum sehir listeyi print eden code create ediniz.
        rs.absolute(0);
        while (rs.next()) {
            System.out.println(rs.getObject("sehir").toString());
        }

        System.out.println("   *** task06 ***     ");
        // task06->tum maas listeyi print eden code create ediniz.
        rs.absolute(0);
        while (rs.next()) {
            System.out.println(rs.getObject("maas").toString());
        }

        System.out.println("   *** task07 ***     ");
        // task07->tum sirket listeyi print eden code create ediniz.
        rs.absolute(0);
        while (rs.next()) {
            System.out.println(rs.getObject("sirket").toString());
        }












    }
}
