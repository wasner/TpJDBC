package TpJDBC;

import java.sql.SQLException;

/**
 * Created by j�r�my on 25/10/2015.
 */
public class testDAO {
    public static void main (String[] args ) throws SQLException {
        DAOEtudiant dao = DAOEtudiant.getInstance();
        //Cr�ation d'un nouvelle �tudiant avec des attributs
        Etudiant etu = new Etudiant();
        etu.setNomEt("wasner");
        etu.setPrenomEt("J�r�my");
        etu.setCpEt("13110");
        etu.setVilleEt("Aix-En-Provence");
        etu.setAnnee(2);
        etu.setGroupe(3);

        //Test insertion dans la base de donn�e de notre �tudiant cr�er pr�cedemment
        etu = dao.insert(etu);

        //Test Update car les accents ne sont pas pris en compte
        etu.setPrenomEt("jeremy");
        //V�rification de la mise � jour
        boolean Update = dao.update(etu);
        //Test suppression �tudiant
        boolean Delete = dao.delete(etu);

    }
}
