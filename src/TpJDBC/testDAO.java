package TpJDBC;

import java.sql.SQLException;

/**
 * Created by jérémy on 25/10/2015.
 */
public class testDAO {
    public static void main (String[] args ) throws SQLException {
        DAOEtudiant dao = DAOEtudiant.getInstance();
        //Création d'un nouvelle étudiant avec des attributs
        Etudiant etu = new Etudiant();
        etu.setNomEt("wasner");
        etu.setPrenomEt("Jérémy");
        etu.setCpEt("13110");
        etu.setVilleEt("Aix-En-Provence");
        etu.setAnnee(2);
        etu.setGroupe(3);

        //Test insertion dans la base de donnée de notre étudiant créer précedemment
        etu = dao.insert(etu);

        //Test Update car les accents ne sont pas pris en compte
        etu.setPrenomEt("jeremy");
        //Vérification de la mise à jour
        boolean Update = dao.update(etu);
        //Test suppression étudiant
        boolean Delete = dao.delete(etu);

    }
}
