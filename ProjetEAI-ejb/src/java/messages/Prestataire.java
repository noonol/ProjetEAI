/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd_eai;

/**
 *
 * @author Rigal
 */
public class Prestataire {
    private String SIREN;
    private String adresseP;
    
    //Constructeur
    public Prestataire(String SIREN, String adresseP) {
        this.SIREN = SIREN;
        this.adresseP = adresseP;
    }

    public String getSIREN() {
        return SIREN;
    }

    public void setSIREN(String SIREN) {
        this.SIREN = SIREN;
    }

    public String getAdresseP() {
        return adresseP;
    }

    public void setAdresseP(String adresseP) {
        this.adresseP = adresseP;
    }

    @Override
    public String toString() {
        return "Prestataire{" + "SIREN=" + SIREN + ", adresseP=" + adresseP + '}';
    }
    
}
