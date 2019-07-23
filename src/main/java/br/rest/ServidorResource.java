
package br.rest;

import br.model.Cliente;
import java.util.ArrayList;
import javax.validation.constraints.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;


@Path("servidor")
public class ServidorResource {

    @Context
    private UriInfo context;

    
    public ServidorResource() {
    }

    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Cliente> get() {
        return new br.dao.CrudClientes().listar();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON) 
    @Path("/{id}")
    public Cliente get(@PathParam("id") int codigo) {
        ArrayList<Cliente> lcli = new br.dao.CrudClientes().listar();
        Cliente cli = null;
        for (Cliente c : lcli) {
            if (c.getCodigo() == codigo) {
                cli = c;
            }
        }
        return cli;
    }
    
    
    
    
    
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
