/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp.gl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author DELL
 */
public class DeleteBook {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/Libraryloansystem";
        String user = "root";
        String password = "";
        return DriverManager.getConnection(url, user, password);
    }

    public void DeleteBook(int ref, String title, String author, String editor, LocalDate publish_year) throws SQLException {
        String query = " DELETE FROM Book ";
        
       try (Connection conn = DeleteBook.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {

        stmt.setInt(1, ref);
        int rowsAffected = stmt.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Book deleted successfully!");
        } else {
            System.out.println("No book found with the given reference.");
        }
       }}}