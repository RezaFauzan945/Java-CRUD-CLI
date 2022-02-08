package crudzero;

import java.sql.*;

public class Koneksi {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/pbo_reza";
    static final String USER = "root";
    static final String PASS = "";

    Connection konek() {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection koneksi = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("DATABASE TERSAMBUNG!");
            return koneksi;
        } 
        catch(Exception e)
        {
           System.out.println(e);
           return null;
        }
    }
}

