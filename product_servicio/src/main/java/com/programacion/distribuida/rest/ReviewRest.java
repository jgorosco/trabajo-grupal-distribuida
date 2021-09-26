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
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
@Path("/reviews")
public class ReviewRest {

    @Inject
    private ReviewServicio servicio;

    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    public Response hola(){
        String msg = "Hola mundo desde review";
        return Response.ok(msg, MediaType.APPLICATION_JSON).build();
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
