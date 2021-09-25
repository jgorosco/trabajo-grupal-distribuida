package com.programacion.distribuida.rest;

import com.programacion.distribuida.dto.Producto;
import com.programacion.distribuida.servicio.ProductoServicio;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@Path("/")
public class ProductoRest {

    @Inject
    private ProductoServicio servicio;

    @GET
    @Path("test")
    @Produces(MediaType.APPLICATION_JSON)
    public String hola(){
        return "Hola mundo desde producto";
    }

    @GET
    @Path("todos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Producto> listar(){
        return servicio.listar();
    }

}
