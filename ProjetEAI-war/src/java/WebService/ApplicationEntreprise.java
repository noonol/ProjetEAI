/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import messages.Client;
import messages.Contrat;
import enumeration.EnumCommunication;
import enumeration.EnumDecoration;
import enumeration.EnumSecurite;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import services.ApplicationEmployes;

/**
 *
 * @author Nolwenn PILLARD
 */
@WebService(serviceName = "ApplicationEntreprise")
public class ApplicationEntreprise {

    @EJB
    private ApplicationEmployes ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "creerContrat")
    public Contrat creerContrat(@WebParam(name = "idContrat") int idContrat, @WebParam(name = "decoration") EnumDecoration decoration, @WebParam(name = "communication") EnumCommunication communication, @WebParam(name = "securite") EnumSecurite securite, @WebParam(name = "montantGlobal") float montantGlobal, @WebParam(name = "nbPersonnes") int nbPersonnes, @WebParam(name = "leClient") Client leClient) {
        return ejbRef.creerContrat(idContrat, decoration, communication, securite, montantGlobal, nbPersonnes, leClient);
    }
    
}
