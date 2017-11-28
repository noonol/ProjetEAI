/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import enumeration.EnumTypePersonne;
import enumeration.EtatContrat;
import enumeration.typePrestations;
import java.util.Date;
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
import messages.Personnel;
import messages.Repas;
import messages.Traiteur;

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

    @EJB
    SingletonTraiteur traiteurs;

    @EJB
    SingletonRepas lesRepas;

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
      
  }
  /* public void GererRestauration(Contrat monContrat) {
        float montantPrevu = 0;

        if (monContrat.getTypePresta() == typePrestations.assis) {
            // Prévoir traiteur
            montantPrevu = PrevoirTraiteurMontant(monContrat.getNbPersonnes(), monContrat.getDateHeureDebut(), monContrat.getDateHeureFin());
            // Set montant repas = montant traiteur + 15%
            montantPrevu = montantPrevu + ((montantPrevu * 15) / 100);
            // Old : on renvoie montant à la fin monContrat.setMontantGlobal(montantPrevu);

            // Pour la gestion du personnel : 
            //  TODO NOL   montantPrevu= montantPrevu + PrévoirPersonnel(EnumTypePersonne.personnelDeService, monContrat.getIdContrat(), 2);
            ObjectMessage om = context.createObjectMessage(monContrat);
            context.createProducer().send(topic, om);

        } else {
            // Calcul nb bouteilles
            Integer nbBouteillesNecessaires = CalculNbBouteilles(monContrat.getDateHeureDebut(), monContrat.getDateHeureFin(), monContrat.getNbPersonnes());
// Integer MP= calculNbMPNecessaire(debut, fin, nb persone)

            // On crée le repas 
            Repas monRepas = new Repas(lesRepas.getSizeLesRepas() + 1, monContrat.getTypePresta(), montantPrevu, traiteurs.getTraiteur(1), monContrat.getIdContrat(), monContrat.isCocktailMaison());
            lesRepas.add(monRepas);
            if (monRepas.getCocktailMaison() == true) {
                //   TODO NOL    PrévoirPersonnel(EnumTypePersonne.preparateurCocktail, monContrat.getIdContrat(), 2);
                ObjectMessage om2 = context.createObjectMessage(monContrat);
                context.createProducer().send(topic, om2);
            }
            if (monRepas.getTypePrestation() == typePrestations.cocktail) {
// Bouteille : regarder si assez (nb, eau plate, eau gaz, mutli fruit, apero1, apero2, apero3)
// ne pas oublier le return montant + décrémentation du stock
// return (OK/ NOK, liste à commander)
// Prevision bouteille : creer (idRepas, nb, eau plate, eau gaz, mutli fruit, apero1, apero2, apero3)*

// MPrepas : regarder si assez (MP, canapés, verrines)
// ne pas oublier le return montant + décrémentation du stock
// return (OK/ NOK, liste à commander)
// Prevision MP : creer (idRepas, MP, canapés, verrines)*
            }
            if (monRepas.getTypePrestation() == typePrestations.lunch) {
// Bouteille : regarder si assez (nb, eau plate, eau gaz, mutli fruit, apero1, apero2, apero3,vin)
// ne pas oublier le return montant + décrémentation du stock
// return (OK/ NOK, liste à commander)
// Prevision bouteille : creer (idRepas, nb, eau plate, eau gaz, mutli fruit, apero1, apero2, apero3,vin)

// MPrepas : regarder si assez (MP, plats froids)
// ne pas oublier le return montant + décrémentation du stock
// return (OK/ NOK, liste à commander)
// Prevision MP : creer (idRepas, MP, plats froids)
            }
            // SET montant dans repas 
            // return montant dans gestion de projet 
        }

        // TODO laisser ou pas ?
        monContrat.setEtat(EtatContrat.gestion_restauration_creer);
    }

    public float PrevoirTraiteurMontant(Integer NbPers, Date dtHeureDebut, Date dtHeureFin) {
        float montantPrevu = 0;
        long nbJours = Math.abs(dtHeureDebut.getTime() - dtHeureFin.getTime());
        // 20 e par jour et par personnes
        montantPrevu = (nbJours * 20) * NbPers;
        return montantPrevu;
    }

    // Calcul du nomobre de bouteilles dont on a besoin
    public int CalculNbBouteilles(Date date1, Date date2, Integer nbPersonnes) {
        Integer res = 0;
        Long diff = diffDateApprox(date1, date2);

        Integer nbBoutPrUnePersPrDemiJour = 1;
        // Une demi journée
        if (diff < 12) {
            res = nbBoutPrUnePersPrDemiJour * nbPersonnes * 1;
        } else if (diff < 24) { // une journée 
            res = nbBoutPrUnePersPrDemiJour * nbPersonnes * 2;
        } else if (diff < 36) { // 1 jour + 1 demi
            res = nbBoutPrUnePersPrDemiJour * nbPersonnes * 3;
        } else if (diff < 48) { // 2 jours
            res = nbBoutPrUnePersPrDemiJour * nbPersonnes * 4;
        } else if (diff < 60) { // 2 jours + 1 demi jours
            res = nbBoutPrUnePersPrDemiJour * nbPersonnes * 5;
        } else if (diff < 72) { // 3 jours 
            res = nbBoutPrUnePersPrDemiJour * nbPersonnes * 6;
        } else if (diff >= 72) { // plus de 3 jours 
            res = nbBoutPrUnePersPrDemiJour * nbPersonnes * 7;
        }
        return res;
    }

    // retourne la différnce entre 2 dates sous forme de chaine de caractères
    public Long diffDateApprox(Date date1, Date date2) {
        long diff = date1.getTime() - date2.getTime();
        long seconds = 0;
        long minutes = 0;
        long hours = 0;
        long days = 0;

        while (diff > 1000) {
            diff = diff - 1000;
            seconds++;
            if (seconds == 60) {
                seconds = 0;
                minutes++;
            }

            if (minutes == 60) {
                minutes = 0;
                hours++;
            }

            if (hours == 24) {
                hours = 0;
                days++;
            }
        }

        Long inter = days * 24 * +hours;
        return inter;
    }
*/
}
