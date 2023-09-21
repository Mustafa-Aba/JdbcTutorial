package jdbcLearn.JDBC_practice;

import java.sql.*;


public class P03_DDL {

     /*
                   A) CREATE TABLE, DROP TABLE, ALTER TABLE gibi DDL ifadeleri icin sonuc kümesi (ResultSet)
                      dondurmeyen metotlar kullanilmalidir. Bunun icin JDBC’de 2 alternatif bulunmaktadir.
                         1) execute() metodu
                         2) excuteUpdate() metodu.

                   B)   - execute() metodu her tur SQL ifadesiyle kullanibilen genel bir komuttur.
                        - execute(), Boolean bir deger dondurur.
                        - DDL islemlerin false dondururken, DML islemlerinde true deger dondurur.(ResultSet olusturur)
                        - Ozellikle hangi tip SQL ifadesinin kullanilmasinin gerektiginin belli olmadigi
                          durumlarda tercih edilmektedir.

                   C) - executeUpdate() metodu ise INSERT, Update gibi DML islemlerinde yaygin kullanilir.
                      -  bu islemlerde islemden etkilenen satir sayisini return eder.
                      - Ayrıca, DDL islemlerinde de kullanilabilir ve bu islemlerde 0 return eder.

                    execute() her turlu SQL kjomutuyla kullanilir .......  DDL ---> False    DML----> True
                    executeUpdate()  DDL ----> 0           DML ----->etkilenen satir sayisini verir
               */


    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/javacan";// mysql bağlantı  adresi(path) tanımlandı
        String username = "root";// mysql bağlantı için username   tanımlandı
        String password = "maras46";// mysql bağlantı için password   tanımlandı

        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        System.out.println("   ***   task01   ***   ");
        // Task01-> markalar adında bir tablo oluşturunuz. marka_id int, marka_isim VARCHAR(15), calisan_sayisi int


        //1.yontem : execute () methodu ile
//        statement.execute("drop table if exists markalar;");
//        boolean s1 = statement.execute("create table markalar(marka_id int, marka_isim VARCHAR(15), calisan_sayisi int);");
//
//        System.out.println("markalar tablosu create edildi:(DDL olduğu için false dönmeli) " + s1);
//        //2.yontem : executeUpdate() methodu ile
//        statement.execute("drop table if exists markalar;");
//        int result = statement.executeUpdate("create table markalar(marka_id int, marka_isim VARCHAR(15), calisan_sayisi int);");
//        System.out.println("markalar tablosu create edildi:(DDL olduğu için 0 dönmeli) " + result);
//
//        System.out.println("   ***   task02   ***   ");
//        // Task02->  markalar tablosunu siliniz
//       // System.out.println("markalar tablosunu silindi."+statement.execute("drop table if exists markalar;"));
//
//        System.out.println("   ***   task03   ***   ");
//        // Task03-> markalar tablosuna yeni bir sutun {sube_sayisi int} ekleyiniz.
//
//        System.out.println("markalar tablosuna yeni bir sutun {sube_sayisi int} ekleyiniz."
//                +statement.execute("alter table markalar add sube_sayisi int;"));
//
//        System.out.println("   ***   task04   ***   ");
//        // Task04-> markalar tablosuna yeni bir sutun {sube_sayisi int} ekleyiniz, ancak bu sutunun yeri marka_id den sonra olsun
//
//        System.out.println("markalar tablosuna yeni bir sutun {sube_sayisi int} eklendi."
//                +statement.execute("alter table markalar add sube_sayisi int after marka_id;"));
//
//        System.out.println("   ***   task5   ***   ");
//        // Task05-> markalar tablosunun adini  brands olarak degistiriniz
//
//        System.out.println("markalar tablosunun adini  brands olarak degistirildi."
//                +statement.execute("alter table markalar rename to brands;"));
//
//        System.out.println("   ***   task06   ***   ");
//        // Task06-> markalar tablosunda marka_isim sutununu isim olarak degistiriniz
//
//        System.out.println("markalar tablosunda marka_isim sutununu isim olarak degistirildi."
//                +statement.execute("alter table brands rename column marka_isim to isim;"));

        System.out.println("   ***   task07   ***   ");
        // Task07-> markalar tablosunda marka_isim sutununun data type ini char(20) olarak degistiriniz

        System.out.println("markalar tablosunda marka_isim sutununun data type ini char(20) olarak degistirildi."
                +statement.execute("alter table brands modify column isim char(20);"));


    }
}
