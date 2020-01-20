package s03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverManagerConnector {
    private static final String URL = "jdbc:mysql://localhost:3306/me?serverTimezone=Europe/Rome"; // final perchè sono costanti
    private static final String USER = "me";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) { // getConnection è il metodo statico della classe DriverManager, se lo metto nel try-with-resources la connessione si chiude automaticamente perchè implementa l'interfaccia autoCloseable

            String user = conn.getCatalog(); //con il metodo gc() prendo il nome dell'utente connesso
            if (user == null) {
                user = conn.getSchema();
            }

            System.out.println("Connected as " + user); // stampa che è connesso una volta riuscita la connessione
            // conn.close(); // ogni connessione stabilita deve essere chiusa, ci va se non metto il try-with-resources
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
