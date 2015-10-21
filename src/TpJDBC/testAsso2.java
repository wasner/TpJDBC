/**
 * Created by w14007405 on 21/10/15.
 */
package TpJDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class testAsso2 {
    // La requete de test
    final static private String reqmod = "SELECT * " +
            "FROM NOTATION, MODULE, ETUDIANT " +
            "WHERE NOTATION.NUM_ET = ETUDIANT.NUM_ET " +
            "AND NOTATION.CODE = MODULE.CODE";
    static Statement stmNotes;

    public static void main(String[] args) throws SQLException {
        // Objet materialisant la connexion a la base de donnees
        Map<String, Module> modules;
        Map <Integer, Etudiant> etudiants;
        Connection connection = ConnexionUnique.getInstance().getConnection();

        try {
            // Creation d'une instruction SQL
            stmNotes = connection.createStatement();
            System.out.println("Execution de la requete : " + reqmod );
            ResultSet rset = stmNotes.executeQuery(reqmod);
            while (rset.next()){
                Etudiant etudiant = creerEtudiant(rset);
                Module module = creerModule(rset);
                Notation notation = creerNotation(rset);
                AssociationNotation.getInstance().creerLien(module,etudiant,notation);
            }
            stmNotes.close(); // Fermeture de l'instruction
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

    private static Notation creerNotation(ResultSet resultSet) {
        return null;
    }

    private static Module creerModule(ResultSet resultSet) {
        return null;
    }

    private static Etudiant creerEtudiant(ResultSet resultSet) {
        return null;
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

