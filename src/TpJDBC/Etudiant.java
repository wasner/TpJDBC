/**
 * Created by w14007405 on 16/10/15.
 */
package TpJDBC;

import java.io.Serializable;
import java.util.Set;

public class Etudiant implements Serializable {
    private int numEt;
    private String nomEt;
    private String prenomEt;
    private String cpEt;
    private String villeEt;
    private  int annee;
    private int groupe;


    public void setNumEt(int numEt) {
        this.numEt = numEt;
    }

    public void setNomEt(String nomEt) {
        this.nomEt = nomEt;
    }

    public void setPrenomEt(String prenomEt) {
        this.prenomEt = prenomEt;
    }

    public void setCpEt(String cpEt) {
        this.cpEt = cpEt;
    }

    public void setVilleEt(String villeEt) {
        this.villeEt = villeEt;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public void setGroupe(int groupe) {
        this.groupe = groupe;
    }

    public int getNumEt() {
        return numEt;
    }

    public String getNomEt() {
        return nomEt;
    }

    public String getPrenomEt() {
        return prenomEt;
    }

    public String getCpEt() {
        return cpEt;
    }

    public int getAnnee() {
        return annee;
    }

    public String getVilleEt() {
        return villeEt;
    }

    public int getGroupe() {
        return groupe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Etudiant etudiant = (Etudiant) o;

        if (numEt != etudiant.numEt) return false;
        if (annee != etudiant.annee) return false;
        if (groupe != etudiant.groupe) return false;
        if (!nomEt.equals(etudiant.nomEt)) return false;
        if (!prenomEt.equals(etudiant.prenomEt)) return false;
        if (!cpEt.equals(etudiant.cpEt)) return false;
        return villeEt.equals(etudiant.villeEt);

    }

    @Override
    public int hashCode() {
        int result = numEt;
        result = 31 * result + (nomEt != null ? nomEt.hashCode() : 0);
        result = 31 * result + (prenomEt != null ? prenomEt.hashCode() : 0);
        result = 31 * result + (cpEt != null ? cpEt.hashCode() : 0);
        result = 31 * result + (villeEt != null ? villeEt.hashCode() : 0);
        result = 31 * result + annee;
        result = 31 * result + groupe;
        return result;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "numEt=" + numEt +
                ", nomEt='" + nomEt + '\'' +
                ", prenomEt='" + prenomEt + '\'' +
                ", cpEt='" + cpEt + '\'' +
                ", villeEt='" + villeEt + '\'' +
                ", annee=" + annee +
                ", groupe=" + groupe +
                '}';
    }

}
