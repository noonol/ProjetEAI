/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServer;

import enumeration.EnumCommunication;
import enumeration.EnumDecoration;
import enumeration.EnumSecurite;
import java.util.ArrayList;
import java.util.HashMap;
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
public class ClientsSingleton {

    private final HashMap<String, Client> clients;

    public ClientsSingleton() {
        clients = new HashMap<>();
        // creation des articles
        
        Client c1 = new Client(1, "T.Desprats", "23 rue des coquelicots, 31530 Lévignac, Colocation 6b", "mdp");
        Client c2 = new Client(2, "C.Teyssié", "23 rue des coquelicots, 31530 Lévignac, Colocation 6b", "mdp");
        clients.put("1", c1);
        clients.put("2", c2);
    }

    public HashMap<String, Client> getClients() {
        return clients;
    }

 //  private final ArrayList<Contrat> contrats = new ArrayList<Contrat>() { {contrats.add(new Contrat(1, EnumDecoration.simple, EnumCommunication.videos, EnumSecurite.accesSalle, 456.70f, 70, clients.get(0)));    }  };
}
