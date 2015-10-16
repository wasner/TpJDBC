/**
 * Created by w14007405 on 16/10/15.
 */
package TpJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionUnique {
    private static final String CONNECT_URL = "jdbc:oracle:thin:@//oratorio.aix.univ-amu.fr:1521/ONZEG";
    private static ConnexionUnique instance = null;
    private Connection connection;
    static String login = "et2127";
    static String password = "oEzyBUs";
    static final String DB_NAME = "Oracle";

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
