package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/section19";
            String user = "root";
            String password = "";

            Connection connection = DriverManager.getConnection(url, user, password);

            return connection;
        } catch (Exception e) {
            System.out.println("Connect JDBC error: " + e);
        }

        return null;
    }
}
