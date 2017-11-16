/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import messages.Client;
import messages.Contrat;
import enumeration.EnumCommunication;
import enumeration.EnumDecoration;
import enumeration.EnumSecurite;
import java.util.ArrayList;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

/**
 *
 * @author Marine
 */
@Singleton
@LocalBean
public class GestionProjet  {
    
 private final ArrayList<Contrat> lesContrats = new ArrayList<>();
   public Contrat creerContrat(int idContrat, EnumDecoration decoration, EnumCommunication communication, EnumSecurite securite, float montantGlobal, int nbPersonnes, Client leClient) {
        Contrat c = new Contrat(idContrat, decoration, communication, securite, montantGlobal, nbPersonnes, leClient);
        lesContrats.add(c);
        return c;
    }
    

}
