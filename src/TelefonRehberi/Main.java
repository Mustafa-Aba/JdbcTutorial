package TelefonRehberi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static ArrayList<kayitSinifi> telList = new ArrayList<>();
    static kayitSinifi kayit;
    static DbaseHelper db= new DbaseHelper();
    static Scanner scan= new Scanner(System.in);
    static Scanner scanNl= new Scanner(System.in);



    public static void main(String[] args) {
    telList=db.listData();
    }
}