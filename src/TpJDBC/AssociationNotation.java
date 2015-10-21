/**
 * Created by w14007405 on 21/10/15.
 */
package TpJDBC;

import java.util.Set;

public class AssociationNotation {
    private Set<Lien> liens;

    private AssociationNotation() {
    }

    private final static AssociationNotation instance = new AssociationNotation();

    public void creerLien(Module m, Etudiant e, Notation n) {
        Lien lien = new Lien(m,e);
        lien.setNote(n);
        liens.add(lien);
    }
    public void supprimerLien (Module m, Etudiant e) {
        Lien lien = new Lien(m,e);
        lien
    }
    public void supprimerLien(Lien l) {
        liens.remove(l);
    }
    public Lien getLien(Module m, Etudiant e) {

    }
    public Set<Lien> getLiens(Etudiant e) {

    }
    public Set<Lien> getLiens(Module m) {

    }
    public Set<Module> getModules(Etudiant e) {

    }
    public Set<Etudiant> getEtudiants(Module m) {

    }
    public AssociationNotation getInstance(){

    }
}
