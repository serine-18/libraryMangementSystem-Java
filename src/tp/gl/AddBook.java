package tp.gl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class AddBook {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/Libraryloansystem";
        String user = "root";
        String password = "";
        return DriverManager.getConnection(url, user, password);
    }

    public void AddBook(int ref, String title, String author, String editor, LocalDate publish_year) throws SQLException {
        String query = "INSERT INTO Book (reference, title, author, editor, publish_year) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = AddBook.getConnection();
             PreparedStatement filling = conn.prepareStatement(query)) {

            filling.setInt(1, ref);
            filling.setString(2, title);
            filling.setString(3, author);
            filling.setString(4, editor);
            java.sql.Date sqlDate = java.sql.Date.valueOf(publish_year);
            filling.setDate(5, sqlDate);
            filling.executeUpdate();

            System.out.println("Book added successfully!");

        } catch (SQLException e) {
            e.printStackTrace(); // if anything wrong happened
        }
    }
    public void DeleteBook(int ref) throws SQLException {
    // SQL query to delete a specific book by its reference
    String query = "DELETE FROM Book WHERE reference = ?";

    try (Connection conn = AddBook.getConnection(); // Corrected class name
         PreparedStatement stmt = conn.prepareStatement(query)) {

        // Set the reference parameter
        stmt.setInt(1, ref);

        // Execute the delete query
        int rowsAffected = stmt.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Book deleted successfully!");
        } else {
            System.out.println("No book found with the given reference.");
        }

    } catch (SQLException e) {
        e.printStackTrace(); // Print error details for debugging
    }
}

}
