/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import messages.Client;
import messages.Contrat;
import enumeration.EnumCommunication;
import enumeration.EnumDecoration;
import enumeration.EnumSecurite;
import enumerations.EtatContrat;
import exceptions.ExceptionTropicDejaUtilise;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.jms.Topic;

import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 *
 * @author Marine
 */
@Singleton
@LocalBean
public class GestionProjet implements MessageListener {

    @Resource(lookup = "jms/TopicContrat")
    private Topic topic;
    @Inject
    private JMSContext context;

    // @EJB
    // GestionSalle salle;
    @EJB
    ContratsSingleton contrats;

// private final ArrayList<Contrat> lesContrats = new ArrayList<>();
    /*  public void addMontantContrat(float montantPrevu){
        Message m = context.createConsumer(topic).receive();
        try {
                 ObjectMessage om = (ObjectMessage) m;
                 Object obj = om.getObject();
                 if (obj instanceof Contrat) {
                     //ajout du montant +mise à jour de la liste
                     Contrat c = (Contrat) obj;
                     c.setMontantGlobal(c.getMontantGlobal()+montantPrevu);
                     int idC = c.getIdContrat();
                     for (int i =0;i < lesContrats.size();i++){
                             if(lesContrats.get(i).getIdContrat()==idC){
                                 lesContrats.set(i, c);
                             }
                    }
                 }
             } catch (JMSException ex) {
                 Logger.getLogger(GestionProjet.class.getName()).log(Level.SEVERE, null, ex);
             }
        
   } */
    @Override
    public void onMessage(Message message) {
        if (message instanceof ObjectMessage) {
            try {
                ObjectMessage om = (ObjectMessage) message;
                Object obj = om.getObject();
                if (obj instanceof Contrat) {
                    Contrat c = (Contrat) obj;
                    if (c.getEtat().equals(EtatContrat.validé)) {
                        int idC = c.getIdContrat();
                        for (int i = 0; i < contrats.getSizeContrat(); i++) {
                            if (contrats.getContrat(i).getIdContrat() == idC) {
                                // ZZZ MARINE contrats.add(i, c);
                                contrats.add(c);
                                // J'ai pas réussi à comprendre pourquoi on parcours la liste des contrats et on ajoute dans la meme liste les contrats ... Si tu peux y jeter un oeil :)
                            }
                        }
                        System.out.println("Contrat validé !");
                    }
                }
            } catch (JMSException ex) {
                Logger.getLogger(GestionProjet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
