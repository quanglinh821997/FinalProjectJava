package Z_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionM {

    String url = "jdbc:mysql://localhost:3306/shop";
    String user = "root";
    String password = "";

    public Connection getConnection() {
        try{
            Connection connection = DriverManager.getConnection(url,user,password);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
