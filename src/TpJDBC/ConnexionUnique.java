/**
 * Created by w14007405 on 16/10/15.
 */
package TpJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionUnique {
    //private static final String CONNECT_URL = "jdbc:oracle:thin:@//oratorio.aix.univ-amu.fr:1521/ONZEG";
    private static final String CONNECT_URL = "jdbc:mysql://localhost:3306/gestion_pedagogique_iut";
    private static ConnexionUnique instance = null;
    private Connection connection;
    //static String login = "et2127";
    static String login = "jerem";
    //static String password = "oEzyBUs";
    static String password = "test";
    //static final String DB_NAME = "Oracle";
    static final String DB_NAME = "MYSQL";

    private ConnexionUnique() throws SQLException {
        System.out.println("Connecté à " + DB_NAME + "\n");
        connection = DriverManager.getConnection(CONNECT_URL, login, password);
    }//ConnexionUnique()

    public Connection getConnection() {
        return connection;
    }//Connection getConnextion()

    public static ConnexionUnique getInstance() throws SQLException {
        if (instance == null) {
            instance = new ConnexionUnique();
        }
        return instance;
    }//ConnexionUnique getInstance()
}//Class ConnexionUnique
