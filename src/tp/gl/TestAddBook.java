/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp.gl;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author DELL
 */

public class TestAddBook {
    public static void main(String[] args) {
        AddBook addBookInstance = new AddBook();

        try {
            // Example book data
            int ref = 1200;
            String title = "Verity";
            String author = "Colleen Hoover";
            String editor = "Warner Books";
            LocalDate publishYear = LocalDate.of(2007, 4, 1);

            // Add book to the database
            addBookInstance.AddBook(ref, title, author, editor, publishYear);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
