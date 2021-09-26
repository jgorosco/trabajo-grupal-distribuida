package com.programacion.distribuida.rest;

import com.programacion.distribuida.dominio.Review;
import com.programacion.distribuida.servicio.ReviewServicio;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@Path("/reviews")
public class ReviewRest {

    @Inject
    private ReviewServicio servicio;

    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    public String hola(){
        return "Hola mundo desde review";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Review> todos(){
        return servicio.listar();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Review listarPorId(@PathParam("id") Integer id){
        return servicio.listarPorId(id);
    }

    @GET
    @Path("producto/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Review> todos(@PathParam("id") Integer id){
        return servicio.listarPorIdProducto(id);
    }

}
