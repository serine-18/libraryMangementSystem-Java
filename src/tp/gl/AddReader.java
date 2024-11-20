package tp.gl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddReader {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/Libraryloansystem";
        String user = "root";
        String password = "";
        return DriverManager.getConnection(url, user, password);
    }

    // Add `throws SQLException` here
    public void AddReader(int id, String first_name, String last_name, String address, int total_books) throws SQLException {
        String query = "INSERT INTO reader (id, first_name, last_name, address, total_books_loaned) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = AddReader.getConnection();
             PreparedStatement filling = conn.prepareStatement(query)) {

            filling.setInt(1, id);
            filling.setString(2, first_name);
            filling.setString(3, last_name);
            filling.setString(4, address);
            filling.setInt(5, total_books);
            filling.executeUpdate();

            System.out.println("Reader added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
