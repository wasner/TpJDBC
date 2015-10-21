/**
 * Created by jérémy on 21/10/2015.
 */
package TpJDBC;

public class Enseignement {
    private Module module;
    private Etudiant etudiant;
    private Prof prof;

    public Enseignement(Module module, Etudiant etudiant, Prof prof) {
        this.module = module;
        this.etudiant = etudiant;
        this.prof = prof;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Prof getProf() {
        return prof;
    }

    public void setProf(Prof prof) {
        this.prof = prof;
    }

    @Override
    public String toString() {
        return "Enseignement{" +
                "module=" + module +
                ", etudiant=" + etudiant +
                ", prof=" + prof +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Enseignement that = (Enseignement) o;

        if (module != null ? !module.equals(that.module) : that.module != null) return false;
        if (etudiant != null ? !etudiant.equals(that.etudiant) : that.etudiant != null) return false;
        return !(prof != null ? !prof.equals(that.prof) : that.prof != null);

    }

    @Override
    public int hashCode() {
        int result = module != null ? module.hashCode() : 0;
        result = 31 * result + (etudiant != null ? etudiant.hashCode() : 0);
        result = 31 * result + (prof != null ? prof.hashCode() : 0);
        return result;
    }
}
