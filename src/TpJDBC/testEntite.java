/**
 * Created by w14007405 on 16/10/15.
 */
package TpJDBC;

import java.sql.*;
import java.util.ArrayList;

public class testEntite {
        // La requete de test
    static final String req = "SELECT NUM_ET, NOM_ET, PRENOM_ET " +
            "FROM ETUDIANT " +
            "WHERE VILLE_ET = 'AIX-EN-PROVENCE'";
    public static void main(String[] args) throws SQLException {
        // Objet materialisant la connexion a la base de donnees
        Connection connection = ConnexionUnique.getInstance().getConnection();
        ArrayList <Etudiant> arraylis= new ArrayList <Etudiant>();
        try {
            // Creation d'une instruction SQL
            Statement stmt = connection.createStatement();
            // Execution de la requete
            System.out.println("Execution de la requete : " + req );
            ResultSet rset = stmt.executeQuery(req);
            // Affichage du resultat
            while (rset.next()){
				/*System.out.print(rset.getInt("NUM_ET") + " ");
				System.out.print(rset.getString("NOM_ET") + " ");
				System.out.println(rset.getString("PRENOM_ET"));*/
                arraylis.add(new Etudiant());
                arraylis.get(arraylis.size()-1).setNumEt(rset.getInt("NUM_ET"));
                arraylis.get(arraylis.size()-1).setNomEt(rset.getString("NOM_ET"));
                arraylis.get(arraylis.size()-1).setPrenomEt(rset.getString("PRENOM_ET"));
                System.out.print(arraylis.get(arraylis.size()-1).getNumEt()+ " ");
                System.out.print(arraylis.get(arraylis.size()-1).getNomEt()+ " ");
                System.out.println(arraylis.get(arraylis.size()-1).getPrenomEt()+ " ");
            }
            // Fermeture de l'instruction (liberation des ressources)
            stmt.close();
            System.out.println("\nOk.\n");
        } catch (SQLException e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        } finally {
            if (connection!= null) {
                // Deconnexion de la base de donnees
                connection.close();
            }
        }
    }
}