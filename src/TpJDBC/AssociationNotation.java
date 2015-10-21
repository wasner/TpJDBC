/**
 * Created by w14007405 on 21/10/15.
 */
package TpJDBC;

import java.util.HashSet;
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
        liens.remove(new Lien(m,e));
    }
    public void supprimerLien(Lien l) {
        liens.remove(l);
    }
    public Lien getLien(Module m, Etudiant e) {
        Lien lien1 = new Lien(m,e);
        for(Lien lien : liens){
            if(lien1.equals(lien)){
                return lien;
            }
        }
        return null;
    }
    public Set<Lien> getLiens(Etudiant e) {
        Set<Lien> lien2 = new HashSet<>();
        for(Lien lien : liens){
            if(lien.getEtudiant().equals(e)){
                lien2.add(lien);
            }
        }
        return lien2;
    }
    public Set<Lien> getLiens(Module m) {
        Set<Lien> lien2 = new HashSet<>();
        for(Lien lien : liens){
            if(lien.getModule().equals(m)){
                lien2.add(lien);
            }
        }
        return lien2;
    }
    public Set<Module> getModules(Etudiant e) {
        Set<Module> mod = new HashSet<>();
        for(Lien lien : liens){
            if(lien.getEtudiant().equals(e)){
                mod.add(lien.getModule());
            }
        }
        return mod;
    }
    public Set<Etudiant> getEtudiants(Module m) {
        Set<Etudiant> etu = new HashSet<>();
        for(Lien lien : liens){
            if(lien.getModule().equals(m)){
                etu.add(lien.getEtudiant());
            }
        }
        return etu;
    }
    public AssociationNotation getInstance(){
        return instance;
    }
}
