package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {


        private  static  String URL="jdbc:mysql://localhost:3306/ banque";
        private  static  String Usernom= "myuser";
        private  static  String Password= "mypassword";


        public static Connection ouvrir() throws SQLException {
           return  DriverManager.getConnection(URL,Usernom,Password);

        }
    }

