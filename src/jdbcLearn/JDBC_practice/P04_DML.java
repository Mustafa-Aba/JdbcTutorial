package jdbcLearn.JDBC_practice;
import java.sql.*;

public class P04_DML {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/javacan";// mysql bağlantı  adresi(path) tanımlandı
        String username = "root";// mysql bağlantı için username   tanımlandı
        String password = "maras46";// mysql bağlantı için password   tanımlandı

        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();

        System.out.println("   ***   task01   ***   ");
        // Task01-> Calisanlar tablosuna yeni bir kayit ((1005, 'Serap Hanım' , 33000)  ekleyelip kaydi teyit icin sorgulayınız.


        //table son hali intelij de gorelim


        System.out.println("   ***   task02   ***   ");
        // Task02-> Calisanlar tablosuna birden fazla yeni kayıt ekleyelim.

        // 1.YONTEM
        // Ayri ayri sorgular ile veritabanina tekrar tekrar ulasmak islemlerin yavas yapilmasina yol acar.
        // 10000 tane veri kaydi yapildigi dusunuldugunde  bu kotu bir yaklasimdir.


        // 2.YONTEM --> addBath ve excuteBatch() metotlari ile
        // addBatch() -> metodu ile SQL ifadeleri gruplandirilabilir ve exucuteBatch()  metodu ile veritabanina bir kere gonderilebilir.
        // ***!!!!**** excuteBatch() metodu bir int [] dizi dondurur ve  Bu dizi her bir ifade sonucunda etkilenen satir sayisini return eder.



    }
}
