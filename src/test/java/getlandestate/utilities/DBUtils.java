package getlandestate.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {

    public static Connection connection;
    public static Statement statement;
    public static ResultSet resultSet;

    public static Connection connectToDatabase() {
        String url = "jdbc:postgresql://64.227.123.49:5432/prettier";
        String username = "postgres";
        String password = "changeme";

        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established successfully.");
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
            throw new RuntimeException(e);
        }

        return connection;
    }

    public static void closeConnection() {
        try {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            System.err.println("Failed to close connection: " + e.getMessage());
        }
    }
}
