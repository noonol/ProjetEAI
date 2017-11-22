/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import enumerations.EnumCommunication;
import enumerations.EnumDecoration;
import enumerations.EnumSecurite;
import java.util.ArrayList;
import java.util.HashMap;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import messages.Client;
import messages.Contrat;
import messages.Salle;

/**
 *
 * @author Rigal
 */
@Singleton
@LocalBean
public class SalleSingleton {

    private final ArrayList<Salle> lesSalles = new ArrayList<>();

    public SalleSingleton() {
        Salle salle = new Salle(1, "Salle de la déchéance", true, true, 3500);
        Salle salle2 = new Salle(2, "Salle amalékoum", true, true, 2500);
        Salle salle3 = new Salle(3, "Salle ami", true, false, 1500);
        Salle salle4 = new Salle(4, "Salle add", true, false, 1500);
        Salle salle5 = new Salle(5, "Salle histoire", false, false, 1000);
        Salle salle6 = new Salle(6, "Salle cheap", false, false, 500);
    }

    public ArrayList<Salle> getLesSalles() {
        return lesSalles;
    }

    public Salle getSalle(Integer idSalle) {
        return lesSalles.get(idSalle);
    }
}
