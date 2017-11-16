/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import javax.ejb.Singleton;
import javax.ejb.LocalBean;

import messages.Client;
import messages.Contrat;
import enumeration.EnumCommunication;
import enumeration.EnumDecoration;
import enumeration.EnumSecurite;
import java.util.ArrayList;

//import javax.ejb.Stateless;
/**
 *
 * @author Nolwenn PILLARD
 */
@Singleton
@LocalBean
public class ApplicationEmployes {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
/*    private final ArrayList<Client> clients = new ArrayList<Client>() {
        {
            clients.add(new Client(1, "T.Desprats", "23 rue des coquelicots, 31530 Lévignac, Colocation 6b", "mdp"));
            clients.add(new Client(2, "C.Teyssié", "23 rue des coquelicots, 31530 Lévignac, Colocation 6b", "mdp"));
        }
    };

    private final ArrayList<Contrat> contrats = new ArrayList<Contrat>() {
        {
            contrats.add(new Contrat(1, EnumDecoration.simple, EnumCommunication.videos, EnumSecurite.accesSalle, 456.70f, 70, clients.get(0)));
        }
    }; */

    public Contrat creerContrat(int idContrat, EnumDecoration decoration, EnumCommunication communication, EnumSecurite securite, float montantGlobal, int nbPersonnes, Client leClient) {
        Contrat contrat = new Contrat(idContrat, decoration, communication, securite, montantGlobal, nbPersonnes, leClient);
        return contrat;
    }

}
