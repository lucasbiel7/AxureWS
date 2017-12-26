/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.polisys.axurews.control.rest;

import br.com.polisys.axurews.model.Database;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author POLISYS
 */
@Path("rest")
public class Rest {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Rest
     */
    public Rest() {
    }

    /**
     * Retrieves representation of an instance of br.com.polisys.axurews.rest.Rest
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        return Database.DATABASE;
    }

    /**
     * PUT method for updating or creating an instance of Rest
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
