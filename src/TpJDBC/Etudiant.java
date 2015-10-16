/**
 * Created by w14007405 on 16/10/15.
 */
package TpJDBC;

public class Etudiant {
    private int numEt=0;
    private String nomEt=null;
    private String prenomEt=null;
    private String cpEt=null;
    private String villeEt=null;
    private  int annee=0;
    private int groupe=0;

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
}
