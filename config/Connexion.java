package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {


    private static final String URL =
            "jdbc:mysql://localhost:3306/banque";

    private static final String USER = "root";

    private static final String PASSWORD = "";

    public static Connection ouvrir() {

        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (SQLException e) {
            System.out.println("Erreur : " + e.getMessage());
            return null;
        }
    }
}
