/**
 * Created by w14007405 on 21/10/15.
 */
package TpJDBC;


import java.sql.*;
import java.util.ArrayList;


public class testAsso3 {
    // La requete de test
    final static private String reqmod = "SELECT * " +
            "FROM ENSEIGNT,PROF, NOTATION, MODULE, ETUDIANT " +
            "WHERE NOTATION.NUM_ET = ETUDIANT.NUM_ET " +
            "AND NOTATION.CODE = MODULE.CODE " +
            "AND PROF.NUM_PROF = ENSEIGNT.NUM_PROF";
    static Statement stmNotes;

    public static void main(String[] args) throws SQLException {
        // Objet materialisant la connexion a la base de donnees
        Connection connection = ConnexionUnique.getInstance().getConnection();


        try {
            // Creation d'une instruction SQL
            stmNotes = connection.createStatement();
            System.out.println("Execution de la requete : " + reqmod );
            ResultSet rset = stmNotes.executeQuery(reqmod);
            ArrayList<Enseignement> enseignements = new ArrayList<Enseignement>();
            while (rset.next()){

                Etudiant etudiant = creerETUDIANT(rset);
                Module module = creerMODULE(rset);
                Prof prof = creerPROF(rset);

                Enseignement e = new Enseignement(module,etudiant,prof);
                e.setEtudiant(etudiant);
                e.setModule(module);
                e.setProf(prof);

                enseignements.add(e);

            }
            //Affichage selon la condition : si il est du groupe 1, affiche l'enseignement
            for (Enseignement e : enseignements) {
                Etudiant et = e.getEtudiant();
                if (1 == et.getGroupe())
                    System.out.println(e);
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

    private static Prof creerPROF(ResultSet rset) throws SQLException { //CreerProf Q5
        Prof prof = new Prof ();
        prof.setNumProf(rset.getInt("NUM_PROF"));
        prof.setNomProf(rset.getString("NOM_PROF"));
        prof.setPrenomProf(rset.getString("PRENOM_PROF"));
        prof.setAdrProf(rset.getString("ADR_PROF"));
        prof.setCpProf(rset.getString("CP_PROF"));
        prof.setVilleProf(rset.getString("VILLE_PROF"));
        return prof;
    }

    private static Module creerMODULE(ResultSet rset) throws SQLException { //CreerModule Q5
        Module module = new Module ();
        module.setCode(rset.getString("CODE"));
        module.setLibelle(rset.getString("LIBELLE"));
        module.sethCoursPrev(rset.getInt("H_COURS_PREV"));
        module.sethCoursRea(rset.getInt("H_COURS_REA"));
        module.sethTpPrev(rset.getInt("H_TP_PREV"));
        module.sethTpRea(rset.getInt("H_TP_REA"));
        module.setDiscipline(rset.getString("DISCIPLINE"));
        module.setCoefTest(rset.getInt("COEFF_TEST"));
        module.setCoefCc(rset.getInt("COEFF_CC"));
        return module;
    }

    private static Etudiant creerETUDIANT(ResultSet rset) throws SQLException { //CreerEtudiant Q5
        Etudiant etudiant = new Etudiant ();
        etudiant.setNumEt(rset.getInt("NUM_ET"));
        etudiant.setNomEt(rset.getString("NOM_ET"));
        etudiant.setPrenomEt(rset.getString("PRENOM_ET"));
        etudiant.setCpEt(rset.getString("CP_ET"));
        etudiant.setVilleEt(rset.getString("VILLE_ET"));
        etudiant.setAnnee(rset.getInt("ANNEE"));
        etudiant.setGroupe(rset.getInt("GROUPE"));
        return etudiant;
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
        PreparedStatement PStmt = connection.prepareStatement(reqmod);

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

