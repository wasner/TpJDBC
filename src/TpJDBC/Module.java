/**
 * Created by w14007405 on 16/10/15.
 */
package TpJDBC;


import java.io.Serializable;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Module module = (Module) o;

        if (coefCc != module.coefCc) return false;
        if (coefTest != module.coefTest) return false;
        if (hCoursPrev != module.hCoursPrev) return false;
        if (hCoursRea != module.hCoursRea) return false;
        if (hTpPrev != module.hTpPrev) return false;
        if (hTpRea != module.hTpRea) return false;
        if (code != null ? !code.equals(module.code) : module.code != null) return false;
        if (discipline != null ? !discipline.equals(module.discipline) : module.discipline != null) return false;
        if (libelle != null ? !libelle.equals(module.libelle) : module.libelle != null) return false;
        if (pere != null ? !pere.equals(module.pere) : module.pere != null) return false;
        return !(responsable != null ? !responsable.equals(module.responsable) : module.responsable != null);

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
        return "Module{" +
                "code='" + code + '\'' +
                ", coefCc=" + coefCc +
                ", coefTest=" + coefTest +
                ", discipline='" + discipline + '\'' +
                ", hCoursPrev=" + hCoursPrev +
                ", hCoursRea=" + hCoursRea +
                ", hTpPrev=" + hTpPrev +
                ", hTpRea=" + hTpRea +
                ", libelle='" + libelle + '\'' +
                ", pere=" + pere +
                ", responsable=" + responsable +
                '}';
    }
}