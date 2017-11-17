/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import enumeration.EnumCommunication;
import enumeration.EnumDecoration;
import enumeration.EnumSecurite;
import java.util.HashMap;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import messages.Client;
import messages.Contrat;

/**
 *
 * @author Nolwenn PILLARD
 */
@Singleton
@LocalBean
public class ContratsSingleton {

    @EJB
    ClientsSingleton clients;

    private final HashMap<String, Contrat> contrats;

    public ContratsSingleton() {
        contrats = new HashMap<>();
        // creation des contrats
        //  Client clt = clients.getClients().get(1);
        // null pointer exception 
        Client clt = new Client(1, "T.Desprats", "23 rue des coquelicots, 31530 Lévignac, Colocation 6b", "mdp"); 
        Contrat c1 = new Contrat(1, EnumDecoration.simple, EnumCommunication.videos, EnumSecurite.accesSalle, 456.70f, 70, clt);

    }

    public HashMap<String, Contrat> getContrats() {
        return contrats;
    }
}
