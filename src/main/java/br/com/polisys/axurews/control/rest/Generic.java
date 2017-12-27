/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.polisys.axurews.control.rest;

import br.com.polisys.axurews.control.Conexao;
import br.com.polisys.axurews.control.dao.GenericDAO;
import br.com.polisys.axurews.control.dao.UsuarioDAO;
import br.com.polisys.axurews.model.Database;
import br.com.polisys.axurews.model.entidades.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author POLISYS
 */
@Path("generic")
public class Generic {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Rest
     */
    public Generic() {
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

    @Path("/select/{tabela}")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public List<?> select(@PathParam("tabela") String tabela){
        try {
            return new UsuarioDAO().pegarTodos();
        } catch (SQLException ex) {
            Logger.getLogger(Generic.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
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
