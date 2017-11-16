/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messages;

import java.util.Date;

/**
 *
 * @author Rigal
 */
public class Planning {
    private Date dateHeureDebut;
    private Date dateHeureFin;
    private Personne laPersonne;
    private Contrat leContrat;
    private Salle laSalle;
    public Planning(Date dateHeureDebut, Date dateHeureFin) {
        this.dateHeureDebut = dateHeureDebut;
        this.dateHeureFin = dateHeureFin;
    }

    public Date getDateHeureDebut() {
        return dateHeureDebut;
    }

    public void setDateHeureDebut(Date dateHeureDebut) {
        this.dateHeureDebut = dateHeureDebut;
    }

    public Date getDateHeureFin() {
        return dateHeureFin;
    }

    public void setDateHeureFin(Date dateHeureFin) {
        this.dateHeureFin = dateHeureFin;
    }

    @Override
    public String toString() {
        return "Planning{" + "dateHeureDebut=" + dateHeureDebut + ", dateHeureFin=" + dateHeureFin + '}';
    }
    
}
