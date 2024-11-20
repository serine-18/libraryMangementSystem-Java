package tp.gl;

import java.sql.SQLException;

public class TestAddReader {
    public static void main(String[] args) {
        AddReader addReaderInstance = new AddReader();

        try {
            // Example reader data
            int id = 1;
            String firstName = "John";
            String lastName = "Doe";
            String address = "123 Main St";
            int totalBooksLoaned = 5;

            // Add reader to the database
            addReaderInstance.AddReader(id, firstName, lastName, address, totalBooksLoaned);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
