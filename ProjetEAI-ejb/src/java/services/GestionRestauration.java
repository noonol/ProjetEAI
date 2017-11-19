/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import enumerations.EtatContrat;
import enumerations.typePrestations;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Topic;
import messages.Contrat;

/**
 *
 * @author Nolwenn PILLARD
 */
@Singleton
@LocalBean
public class GestionRestauration implements MessageListener {

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
                    Contrat monContrat = (Contrat) obj;
                    if (monContrat.getEtat().equals(EtatContrat.gestion_projet_creer)) {
                        GererRestauration(monContrat);
                        System.out.println("Contrat arrivé dans la gestionRestauration pour création de contrat !");
                        ObjectMessage omToSend = context.createObjectMessage(monContrat);
                        context.createProducer().send(topic, omToSend);
                        System.out.println("Contrat traité dans GestionRestauration et renvoye le montant pour Gestion de projet!");
                    }
                }
            } catch (JMSException ex) {
                Logger.getLogger(GestionProjet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void GererRestauration(Contrat monContrat) {
        float montantPrevu = 0;
        // Prévoir traiteur
        if (monContrat.getTypePresta()== typePrestations.assis) {
            
        }
        // Set montant repas = montant traiteur + 15%
        
        // Pour la gestion du personnel : PrévoirPersonnel(Personnel de service, idCOntrat, 2)
        
        
        
        
        // TODO 

        monContrat.setEtat(EtatContrat.gestion_restauration_creer);
    }

}
