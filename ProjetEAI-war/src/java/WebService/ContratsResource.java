/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import enumeration.EnumAnimation;
import enumeration.EnumCommunication;
import enumeration.EnumDecoration;
import enumeration.EnumSecurite;
import enumeration.typePrestations;
import exceptions.ExceptionTropicDejaUtilise;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import messages.*;

/**
 * REST Web Service
 *
 * @author Rigal
 */
@Path("generic")
public class ContratsResource {

    @Context
    private UriInfo context;
    ApplicationEmployes contrats = lookupApplicationEmployesBean();
    /**
     * Creates a new instance of ContratsResource
     */
    public ContratsResource() {
    }

    /**
     * Retrieves representation of an instance of WebService.ContratsResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of ContratsResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void postJson(Contrat content) throws ExceptionTropicDejaUtilise {
        contrats.creerContrat(content.getIdContrat(), content.getAnimation(), content.getDecoration(), content.getCommunication(), content.getSecurite(),content.getMontantGlobal(), content.getNbPersonnes(), content.getLeClient(), content.getDateHeureDebut(), content.getDateHeureFin(), content.getSalle(), content.getTypePresta(),content.isCocktailMaison());
       //creerContrat(idContrat, animation, decoration, communication, securite, montantGlobal, nbPersonnes, leClient, debut, fin, mySalle, type, cocktailMaison);
    }
    
    private ApplicationEmployes lookupApplicationEmployesBean() {
        try {
            javax.naming.Context c = new InitialContext();
            return (ApplicationEmployes) c.lookup("java:global/ProjetEAI/ProjetEAI-ejb/ApplicationEmployes!webserver.ApplicationEmployes");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
