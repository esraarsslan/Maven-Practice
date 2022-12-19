package utilities;

import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {

    // connection
    // statiment
    // con ve statement kapatma methodlarini koyacagiz.

    private static Connection connection;

    private static Statement statement;

    //1. Adim Connection olustur..

    public static Connection connectionOlustur(String hostname, String databaseismi, String username, String password) {
        try {
            Class.forName("org.postgresql.Driver"); // driver a kayitoluyoruz.
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);

            // 2.ADIM Connection olustur
            //url syntax:jdbc:postgresql://hostname:portnumber/databaseismi

            String url = "jdbc : postgresql ://" + hostname + ": 5432/" + databaseismi;
            try {

                connection = DriverManager.getConnection(url, username, password);

            } catch (SQLException e) {
                throw new RuntimeException(e);

            }
            return connection;
        }

        public static Statement statementOlustur(){

            try {
                statement = connection.createStatement();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return (Connection) statement;

        }
        public static void connnectionStatementKapat (){

            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public static Statement statementOlustur() {
    }
}