/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp.gl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
/**
 *
 * @author DELL
 */
public class TPGL {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/Libraryloansystem";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            if (connection != null) {
                 AddBook newbook = new AddBook();
                // Emprunt newbook1=new Emprunt();
                 
                // newbook.AddBook(3, "Verity", "Colleen Hoover", "Warner Books", LocalDate.of(2007, 4, 1));
                // AddReader newreader = new AddReader();
                 //newreader.AddReader(2, "John", "Doe", "123 Main St", 5);
                  System.out.println("Connected to the database successfully!");
                 // newbook1.AddEmprunt(1, LocalDate.of(2004,4,18), LocalDate.of(2004,5,18), 0);
            
                  newbook.DeleteBook(3);
                 
                 
                 
             
                
            }
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database.");
        }
    }
}