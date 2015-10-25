package TpJDBC;

import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jérémy on 25/10/2015.
 */
public class DAOEtudiant {

    private static DAOEtudiant instance = new DAOEtudiant();

    private DAOEtudiant() {
    }

    ;

    public Etudiant insert(Etudiant Etu) throws SQLException {
        //Récupère le numéro de l'étudiant le plus gros pour mettre un numéro étudiant au nouveau pas encore utilisé
        String Req = "SELECT MAX(NUM_ET) FROM ETUDIANT";
        ConnexionUnique connexion = ConnexionUnique.getInstance();
        Connection connection = connexion.getConnection();
        Statement statement = connection.createStatement();
        System.out.println(" Execution de la requete : " + Req);
        ResultSet resultSet = statement.executeQuery(Req);
        resultSet.next();
        int Maximum = resultSet.getInt(1);
        Maximum++; // On ajoute un au numéros le plus grand
        String req = "INSERT INTO ETUDIANT (NUM_ET, ANNEE, CP_ET, GROUPE, NOM_ET, PRENOM_ET, VILLE_ET)" +
                " VALUES(" + Maximum + "," +
                "" + Etu.getAnnee() + "," +
                "'" + Etu.getCpEt() + "'," +
                "" + Etu.getGroupe() + "," +
                "'" + Etu.getNomEt() + "'," +
                "'" + Etu.getPrenomEt() + "'," +
                "'" + Etu.getVilleEt() + "')";
        System.out.println(" Execution de la requete : " + req);
        Statement statement1 = connection.createStatement();
        int NbRow = statement1.executeUpdate(req);
        System.out.println(NbRow + " tuple insere avec succes ");
        Etu.setNumEt(Maximum);
        return Etu;
    }

    public boolean delete(Etudiant Etud) throws SQLException {
        try {
            String req = "DELETE FROM ETUDIANT WHERE NUM_ET= " + Etud.getNumEt();
            ConnexionUnique conneU = ConnexionUnique.getInstance();
            Connection connection = conneU.getConnection();
            Statement statement = connection.createStatement();
            System.out.println("Execution de la requete : " + req);
            int NbRow = statement.executeUpdate(req);
            System.out.println(NbRow + " tuple detruit avec succes");
            return true;
        } catch (Exception e) {
            System.out.println("Erreur SQL");
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Etudiant etuU) throws SQLException {
        try {
            String req = "UPDATE ETUDIANT SET NOM_ET='" + etuU.getNomEt() + "', PRENOM_ET='" + etuU.getPrenomEt()
                    + "',CP_ET='" + etuU.getCpEt() + "', VILLE_ET='" + etuU.getVilleEt() + "',ANNEE=" + etuU.getAnnee() + ",GROUPE="
                    + etuU.getGroupe() + " WHERE NUM_ET=" + etuU.getNumEt();

            ConnexionUnique conneU = ConnexionUnique.getInstance();
            Connection connection = conneU.getConnection();
            Statement statement = connection.createStatement();
            System.out.println("Execution de la requete : " + req);
            int NbColonnes = statement.executeUpdate(req);
            System.out.println(NbColonnes + " tuple modifie avec succes");
            return true;
        } catch (Exception e) {
            System.out.println("Erreur SQL");
            e.printStackTrace();
            return false;
        }
    }

    public Etudiant getById(int numEt) throws SQLException {
        try {
            String req = "SELECT * FROM ETUDIANT WHERE NUM_ET=" + numEt;
            ConnexionUnique conneU = ConnexionUnique.getInstance();
            Connection conne = (Connection) conneU.getConnection();
            Statement statement = conne.createStatement();
            ResultSet resultSet = statement.executeQuery(req);
            if (!resultSet.next()) return null;

            Etudiant et = new Etudiant(resultSet.getString("NOM_ET"), resultSet.getInt("NUM_ET"), resultSet.getString("PRENOM_ET"),
                    resultSet.getString("CP_ET"), resultSet.getString("VILLE_ET"),
                    resultSet.getInt("ANNEE"), resultSet.getInt("GROUPE"));
            return et;
        } catch (SQLException e) {
            System.out.println("Erreur SQL");
            e.printStackTrace();
            return null;
        }
    }

    public static DAOEtudiant getInstance() {
        if (instance == null) {
            instance = new DAOEtudiant();
            return instance;
        }
        return instance;
    }
}
