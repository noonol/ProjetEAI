/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messages;

/**
 *
 * @author Nolwenn PILLARD
 */
public class prevision_Bouteille {
    
    private int nbPrevuB;
    private Repas repas;
    private Bouteille bouteille;

    public prevision_Bouteille(int nbPrevuB, Repas repas, Bouteille bouteille) {
        this.nbPrevuB = nbPrevuB;
        this.repas = repas;
        this.bouteille = bouteille;
    }

    public int getNbPrevuB() {
        return nbPrevuB;
    }

    public Repas getRepas() {
        return repas;
    }

    public Bouteille getBouteille() {
        return bouteille;
    }

    public void setNbPrevuB(int nbPrevuB) {
        this.nbPrevuB = nbPrevuB;
    }

    public void setRepas(Repas repas) {
        this.repas = repas;
    }

    public void setBouteille(Bouteille bouteille) {
        this.bouteille = bouteille;
    }

    @Override
    public String toString() {
        return "prevision_Bouteille{" + "nbPrevuB=" + nbPrevuB + ", repas=" + repas + ", bouteille=" + bouteille + '}';
    }

}
