/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enumerations;

/**
 *
 * @author Marine
 */
public enum EtatContrat {
    initialise,
    //quand l'état par gestion, c'est à dire qu'il est utilisé par un bean en particulier
    gestion_projet,
    gestion_restauration,
    gestion_salle,
    gestion_personnel,
    gestion_prestataire_complementaire,
    annulé,
    validé
   
}
