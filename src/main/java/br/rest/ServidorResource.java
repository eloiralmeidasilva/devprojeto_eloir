package br.rest;

import br.model.Cliente;
import java.io.IOException;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void post(String cliente) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Cliente cli = objectMapper.readValue(cliente, Cliente.class);
            new br.dao.CrudClientes().insereCliente(cli);
        } catch (IOException e) {

        }
    }
    
    
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void put(String cliente) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Cliente cli = objectMapper.readValue(cliente, Cliente.class);
            new br.dao.CrudClientes().editar(cli);
        } catch (IOException e) {

        }
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public void delete(@PathParam("id") int codigo) {
        new br.dao.CrudClientes().delete(codigo);
        
    }
    
    
    
}
