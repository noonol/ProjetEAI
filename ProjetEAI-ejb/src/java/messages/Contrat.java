/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messages;

import enumeration.EnumCommunication;
import enumeration.EnumSecurite;
import enumeration.EnumDecoration;
import enumerations.EtatContrat;

/**
 *
 * @author Rigal
 */
public class Contrat {

    public Contrat(int idContrat, EnumDecoration decoration, EnumCommunication communication, EnumSecurite securite, float montantGlobal, int nbPersonnes, Client leClient) {
        this.idContrat = idContrat;
        this.decoration = decoration;
        this.communication = communication;
        this.securite = securite;
        this.montantGlobal = montantGlobal;
        this.nbPersonnes = nbPersonnes;
        this.leClient = leClient;
        this.etat = EtatContrat.initialise;
    }

    public EtatContrat getEtat() {
        return etat;
    }

    public int getIdContrat() {
        return idContrat;
    }

    public EnumDecoration getDecoration() {
        return decoration;
    }

    public EnumCommunication getCommunication() {
        return communication;
    }

    public EnumSecurite getSecurite() {
        return securite;
    }

    public float getMontantGlobal() {
        return montantGlobal;
    }

    public int getNbPersonnes() {
        return nbPersonnes;
    }

    public Client getLeClient() {
        return leClient;
    }

    public void setIdContrat(int idContrat) {
        this.idContrat = idContrat;
    }
    
    public void setEtat(EtatContrat etat) {
        this.etat = etat;
    }

    public void setDecoration(EnumDecoration decoration) {
        this.decoration = decoration;
    }

    public void setCommunication(EnumCommunication communication) {
        this.communication = communication;
    }

    public void setSecurite(EnumSecurite securite) {
        this.securite = securite;
    }

    public void setMontantGlobal(float montantGlobal) {
        this.montantGlobal = montantGlobal;
    }

    public void setNbPersonnes(int nbPersonnes) {
        this.nbPersonnes = nbPersonnes;
    }

    public void setLeClient(Client leClient) {
        this.leClient = leClient;
    }

    @Override
    public String toString() {
        return "Contrat{" + "idContrat=" + idContrat + ", decoration=" + decoration + ", communication=" + communication + ", securite=" + securite + ", montantGlobal=" + montantGlobal + ", nbPersonnes=" + nbPersonnes + ", leClient=" + leClient + '}';
    }
    private int idContrat;
    private EnumDecoration decoration;
    private EnumCommunication communication;
    private EnumSecurite securite;
    private float montantGlobal;
    private int nbPersonnes;
    private Client leClient;
    private EtatContrat etat;
}
