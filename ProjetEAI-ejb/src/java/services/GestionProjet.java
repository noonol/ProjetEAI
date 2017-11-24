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

    @EJB
    ContratsSingleton contrats;

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
                            // ATTENTION : la taille est différente de l'id donc ca peut lever une exception : plutot faire la recherhche sur l'id
                            if (contrats.getContrat(i).getIdContrat() == idC) {
                                // ZZZ MARINE contrats.add(i, c);
                                contrats.add(c);
                                // J'ai pas réussi à comprendre pourquoi on parcours la liste des contrats et on ajoute dans la meme liste les contrats ... Si tu peux y jeter un oeil :)
                            }
                        }
                        System.out.println("Contrat validé !");
                    } else if (c.getEtat().equals(EtatContrat.gestion_restauration_creer)) {
                        // met à jour le montant dans Contrat
                        float montantPrevu = 0;
                        montantPrevu = c.getMontantGlobal();
                        // TODO NOL
                    }
                }
            } catch (JMSException ex) {
                Logger.getLogger(GestionProjet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
