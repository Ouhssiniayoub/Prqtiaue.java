import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() throws SQLException {
        // Replace with your actual database details
        String url = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
        String user = "your_username";
        String password = "your_password";
        return DriverManager.getConnection(url, user, password);
    }
}
