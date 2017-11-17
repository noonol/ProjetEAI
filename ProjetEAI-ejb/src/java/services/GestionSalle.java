/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import enumerations.EtatContrat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import java.util.ArrayList;
import messages.Contrat;
import messages.Salle;

/**
 *
 * @author Rigal
 */
@Singleton
@LocalBean
public class GestionSalle implements MessageListener {
    private final ArrayList<Salle>lesSalles = new ArrayList<>();
    @Override
    public void onMessage(Message message) {
        if (message instanceof ObjectMessage) {
             try {
                 ObjectMessage om = (ObjectMessage) message;
                 Object obj = om.getObject();
                 if (obj instanceof Contrat) {
                     Contrat c = (Contrat) obj;
                     Salle s = (Salle) obj;
                     if (c.getEtat().equals(EtatContrat.gestion_salle)){
                         int idS = s.getIdSalle();
                         
                         System.out.println("Salle réservée !");
                     }
                 }
             } catch (JMSException ex) {
                 Logger.getLogger(GestionProjet.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
