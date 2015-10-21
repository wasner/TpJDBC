/**
 * Created by w14007405 on 16/10/15.
 */
package TpJDBC;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Module implements Serializable {
    private String code;
    private int coefCc;
    private int coefTest;
    private String discipline;
    private int hCoursPrev;
    private int hCoursRea;
    private int hTpPrev;
    private int hTpRea;
    private String libelle;
    private Prof responsable; //Q3
    private Module pere; //Q3

    final private Set<Enseignement> enseignements = new HashSet<>(); //Question 5 relation : A1

    public Module() {
    }

    public Module(String code) {
        this.code = code;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getCoefCc() {
        return coefCc;
    }

    public void setCoefCc(int coefCc) {
        this.coefCc = coefCc;
    }

    public int getCoefTest() {
        return coefTest;
    }

    public void setCoefTest(int coefTest) {
        this.coefTest = coefTest;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public int gethCoursPrev() {
        return hCoursPrev;
    }

    public void sethCoursPrev(int hCoursPrev) {
        this.hCoursPrev = hCoursPrev;
    }

    public int gethCoursRea() {
        return hCoursRea;
    }

    public void sethCoursRea(int hCoursRea) {
        this.hCoursRea = hCoursRea;
    }

    public int gethTpPrev() {
        return hTpPrev;
    }

    public void sethTpPrev(int hTpPrev) {
        this.hTpPrev = hTpPrev;
    }

    public int gethTpRea() {
        return hTpRea;
    }

    public void sethTpRea(int hTpRea) {
        this.hTpRea = hTpRea;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Module getPere() {
        return pere;
    } //Q3

    public void setPere(Module pere) {
        this.pere = pere;
    } //Q3

    public Prof getResponsable() {
        return responsable;
    } //Q3

    public void setResponsable(Prof responsable) {
        this.responsable = responsable;
    } //Q3

    public Set<Enseignement> getEnseignements() { return enseignements; } //Q5

    public void addEnseignement(Enseignement e){ enseignements.add(e); } //Q5

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Module module = (Module) o;
        if (code != null ? !code.equals(module.code) : module.code != null) return false;
        return code != null;
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + coefCc;
        result = 31 * result + coefTest;
        result = 31 * result + (discipline != null ? discipline.hashCode() : 0);
        result = 31 * result + hCoursPrev;
        result = 31 * result + hCoursRea;
        result = 31 * result + hTpPrev;
        result = 31 * result + hTpRea;
        result = 31 * result + (libelle != null ? libelle.hashCode() : 0);
        result = 31 * result + (pere != null ? pere.hashCode() : 0);
        result = 31 * result + (responsable != null ? responsable.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Module{");
        sb.append("code='").append(code).append('\'');
        sb.append(", coefCc=").append(coefCc);
        sb.append(", coefTest=").append(coefTest);
        sb.append(", discipline='").append(discipline).append('\'');
        sb.append(", hCoursPrev=").append(hCoursPrev);
        sb.append(", hCoursRea=").append(hCoursRea);
        sb.append(", hTpPrev=").append(hTpPrev);
        sb.append(", hTpRea=").append(hTpRea);
        sb.append(", libelle='").append(libelle).append('\'');
        sb.append(", responsable=").append(responsable);
        sb.append(", pere=").append(pere);
        sb.append('}');
        return sb.toString();
    }
}