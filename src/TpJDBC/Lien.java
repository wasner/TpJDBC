/**
 * Created by w14007405 on 21/10/15.
 */
package TpJDBC;
import TpJDBC.Etudiant;
import TpJDBC.Notation;
import TpJDBC.Module;

public class Lien {
    private Module module;
    private Etudiant etudiant;
    private Notation note;

    public Lien(Module module, Etudiant etudiant) {
        this.module = module;
        this.etudiant = etudiant;
    }

    public Module getModule() {
        return module;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public Notation getNote() {
        return note;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public void setNote(Notation note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lien lien = (Lien) o;

        if (!module.equals(lien.module)) return false;
        if (!etudiant.equals(lien.etudiant)) return false;
        return note.equals(lien.note);

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Lien{");
        sb.append("module=").append(module.getCode());
        sb.append(", etudiant=").append(etudiant.getNumEt());
        sb.append(", note=").append(note);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = module.hashCode();
        result = 31 * result + etudiant.hashCode();
        result = 31 * result + note.hashCode();
        return result;
    }
}
