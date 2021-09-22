package com.programacion.distribuida.repository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class CustomerRepository {

    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    public String test(){
        return "HOLA MUNDO";
    }
}
