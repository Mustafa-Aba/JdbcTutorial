package Day01;

import TelefonRehberi.kayitSinifi;

import java.sql.*;
import java.util.ArrayList;

public class DbaseHelper {
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;

    public void dbaseConnect() {
        String DB_URL = "jdbc:mysql://localhost:3306/day01";
        String USERNAME = "root";
        String PASSWORD = "maras46";
        try {
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            stmt  = conn.createStatement();
        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Bağlantı başarılı");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver bulunamadı"+e);
        }
    }

    private void useTelRehber() {
        String sql = "Use TelRehber";
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void dbaseClose() {

        try {
            if (conn != null) {
                conn.close();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void createDbase() {
        dbaseConnect();
        try {
            stmt = conn.createStatement();
            String sql = "Create database if not exists TelRehber";
            stmt.executeUpdate(sql);
            useTelRehber();
            sql = "Create table if not exists tel_nolar" + "(id int primary key auto_increment, " +
                    "isim varchar(45)," + "tel varchar(20));";

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void addData(kayitSinifi kayit) {
        dbaseConnect();
        useTelRehber();
        int result = 0;
        String sql = "INSERT INTO tel_nolar(isim,tel) values (?,?);";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, kayit.getIsim());
            pstmt.setString(2, kayit.getTel());
            useTelRehber();
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("result = " + result);
            throw new RuntimeException(e);
        } finally {
            dbaseClose();
        }
    }

    private void deleteData(int id) {
        dbaseConnect();
        useTelRehber();

        String sql = "delete from tel_nolar where id=?;";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            int result = pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.toString());

        } finally {
            dbaseClose();
        }
    }

    private void updateData(kayitSinifi kayit) {
        dbaseConnect();
        useTelRehber();

        String sql = "update tel_nolar set isim=?,tel=? where id=?;";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, kayit.getIsim());
            pstmt.setString(2, kayit.getTel());
            pstmt.setInt(3, kayit.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);

        } finally {
            dbaseClose();
        }
    }

    public ArrayList<kayitSinifi> listData() {
        ArrayList<kayitSinifi> list = new ArrayList<kayitSinifi>();
        createDbase();
        dbaseConnect();
        useTelRehber();
        ResultSet resultSet = null;

        String sql = "select * from tel_nolar;";

        try {
            resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {
                kayitSinifi kayit = new kayitSinifi();
                kayit.setId(resultSet.getInt(1));
                kayit.setIsim(resultSet.getString(2));
                kayit.setTel(resultSet.getString(3));
                list.add(kayit);

            }

        } catch (SQLException e) {
            System.out.println(e.toString());

        } finally {
            dbaseClose();
        }
        return list;
    }
}

