/**
 * Created by w14007405 on 16/10/15.
 */
package TpJDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class testAsso1 {
    // La requete de test
    static final String req = "SELECT * FROM PROF";
    static final String reqM = "SELECT * FROM MODULE WHERE CODE = ?";
    public static void main(String[] args) throws SQLException {
        // Objet materialisant la connexion a la base de donnees
        Connection connection = ConnexionUnique.getInstance().getConnection();

        try {
            // Creation d'une instruction SQL
            Statement stmt = connection.createStatement();
            PreparedStatement Pstmt = connection.prepareStatement(reqM);
            // Execution de la requete
            System.out.println("Execution de la requete : " + req );
            ResultSet rset = stmt.executeQuery(req);
            // Affichage du resultat
            List<Prof> profs= new ArrayList <Prof>();
            while (rset.next()){
                Prof p = getProf(rset);
                profs.add(p);
            }

            profs.forEach(System.out::println); // Lis ligne par ligne la collection profs en java 1.8

            stmt.close(); // Fermeture de l'instruction
            System.out.println("\nOk.\n");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage() + "\n");
        } finally {
            if (connection!= null) {
                connection.close(); // Deconnexion de la base de donnees
            }
        }
    }

    private static Prof getProf(ResultSet rset) throws SQLException {
        Prof p = new Prof();
        p.setNumProf(rset.getInt("NUM_PROF"));
        p.setNomProf(rset.getString("NOM_PROF"));
        p.setPrenomProf(rset.getString("PRENOM_PROF"));
        p.setSpecialite(getModule(rset.getString("MAT_SPEC")));
        return p;
    }

    static private Module getModule(String code) throws SQLException { //Q3
        Module module = null;
        Connection connection = ConnexionUnique.getInstance().getConnection();
        PreparedStatement PStmt = connection.prepareStatement(reqM);

        PStmt.setString(1, code);
        ResultSet rset1 = PStmt.executeQuery();

        if (rset1.next()) {
            module = new Module();
            module.setCode(rset1.getString("CODE"));
            module.setLibelle(rset1.getString("LIBELLE"));
            module.sethCoursPrev(rset1.getInt("H_COURS_PREV"));
            module.sethCoursRea(rset1.getInt("H_COURS_REA"));
            module.sethTpPrev(rset1.getInt("H_TP_PREV"));
            module.setDiscipline(rset1.getString("DISCIPLINE"));
            module.setCoefTest(rset1.getInt("COEFF_TEST"));
            module.setCoefCc(rset1.getInt("COEFF_CC"));
            module.setPere(getModule(rset1.getString("CODEPERE")));
        }
        rset1.close();
        return module;
    }
}