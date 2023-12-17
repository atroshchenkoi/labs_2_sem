package lab11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreator {
    private static Connection connection = null;
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "12345";

    private static boolean flagConnection = false;

    private static void createConnection(){
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/films",
                    USER_NAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection() {
        if (!flagConnection) {
            createConnection();
        }
        return connection;
    }

    public static void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
