package tp.gl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class Emprunt {

    // Database connection method
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/Libraryloansystem";
        String user = "root";
        String password = "";
        return DriverManager.getConnection(url, user, password);
    }

    // AddEmprunt method
    public void AddEmprunt(int id, LocalDate date_de_prunt, LocalDate date_de_retoure, float disponibility) throws SQLException {
        // Corrected SQL query
        String query = "INSERT INTO emprunt (id, date_de_prunt, date_de_retoure, disponibility) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = Emprunt.getConnection(); // Fixed class name
             PreparedStatement filling = conn.prepareStatement(query)) {

            // Set parameters
            filling.setInt(1, id);
            filling.setDate(2, java.sql.Date.valueOf(date_de_prunt)); // Convert LocalDate to SQL Date
            filling.setDate(3, java.sql.Date.valueOf(date_de_retoure));
            filling.setFloat(4, disponibility);

            // Execute update
            filling.executeUpdate();
            System.out.println("Emprunt added successfully!");

        } catch (SQLException e) {
            e.printStackTrace(); // Print error details for debugging
        }
    }
}
