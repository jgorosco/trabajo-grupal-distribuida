package com.programacion.distribuida.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class HolaMundo {
    @GET
    @Path("/hola")
    @Produces(MediaType.APPLICATION_JSON)
    public String hola(){
        return "hola mundo";
    }
}
