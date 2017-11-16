/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messages;

import enumerations.typePrestations;
import java.util.Objects;

/**
 *
 * @author Nolwenn PILLARD
 */
public class Repas {
    
    private int idRepas;
    private typePrestations typePrestation;
    private boolean cocktailMaison;
    private float montantTraiteur;
    private Traiteur traiteur;

    public Repas(int idRepas, typePrestations typePrestation, boolean cocktailMaison, float montantTraiteur, Traiteur traiteur) {
        this.idRepas = idRepas;
        this.typePrestation = typePrestation;
        this.cocktailMaison = cocktailMaison;
        this.montantTraiteur = montantTraiteur;
        this.traiteur = traiteur;
    }

    public int getIdRepas() {
        return idRepas;
    }

    public typePrestations getTypePrestation() {
        return typePrestation;
    }

    public boolean isCocktailMaison() {
        return cocktailMaison;
    }

    public float getMontantTraiteur() {
        return montantTraiteur;
    }

    public Traiteur getTraiteur() {
        return traiteur;
    }

    public void setIdRepas(int idRepas) {
        this.idRepas = idRepas;
    }

    public void setTypePrestation(typePrestations typePrestation) {
        this.typePrestation = typePrestation;
    }

    public void setCocktailMaison(boolean cocktailMaison) {
        this.cocktailMaison = cocktailMaison;
    }

    public void setMontantTraiteur(float montantTraiteur) {
        this.montantTraiteur = montantTraiteur;
    }

    public void setTraiteur(Traiteur traiteur) {
        this.traiteur = traiteur;
    }

    @Override
    public String toString() {
        return "Repas{" + "idRepas=" + idRepas + ", typePrestation=" + typePrestation + ", cocktailMaison=" + cocktailMaison + ", montantTraiteur=" + montantTraiteur + ", traiteur=" + traiteur + '}';
    }

}
