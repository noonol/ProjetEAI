/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.HashMap;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import messages.Contrat;
import messages.Repas;

/**
 *
 * @author Nolwenn PILLARD
 */
@Singleton
@LocalBean
public class SingletonRepas {

    private HashMap<Integer, Repas> repas;

    public SingletonRepas() {
        repas = new HashMap<>();
    }

    public HashMap<Integer, Repas> getRepas() {
        return repas;
    }

    public Repas getRepas(Integer idRepas) {
        return repas.get(idRepas);
    }

    public Repas getRepasDuContrat(Integer idContrat) {
        Repas MonRepas = null;
        for (int i = 0; i < repas.size(); i++) {
            if (repas.get(i).getIdContrat() == idContrat) {
                MonRepas = repas.get(i);
            }
        }
        return MonRepas;
    }

}
