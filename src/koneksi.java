import java.sql.*;

public class koneksi {
    private static Connection koneksi;

    public static Connection getKoneksi() {
        if (koneksi == null || isClosed(koneksi)) { // Check if the connection is null or closed
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost/data";
                String user = "root";
                String password = "";
                koneksi = DriverManager.getConnection(url, user, password);
                System.out.println("Koneksi database berhasil");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return koneksi;
    }

    private static boolean isClosed(Connection conn) {
        try {
            return conn == null || conn.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        }
    }
}