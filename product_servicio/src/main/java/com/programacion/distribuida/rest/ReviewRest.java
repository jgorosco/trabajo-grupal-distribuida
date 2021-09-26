package com.programacion.distribuida.rest;

import com.programacion.distribuida.dominio.Review;
import com.programacion.distribuida.servicio.ReviewServicio;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
@Path("/reviews")
public class ReviewRest {

    @Inject
    private ReviewServicio servicio;

    //Todas las reviews
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Review> todos(){
        return servicio.listar();
    }

    //Obtiene una review por id
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Review listarPorId(@PathParam("id") Integer id){
        return servicio.listarPorId(id);
    }
    //Obtiene todas las reviews de un producto por su id
    @GET
    @Path("producto/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Review> todos(@PathParam("id") Integer id){
        return servicio.listarPorIdProducto(id);
    }

    //Crea una review
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void crear(Review review){
        servicio.crear(review);
    }

    //Edita una review
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void editar(Review review){
        servicio.editar(review);
    }

    //Elimina una review
    @DELETE
    @Path("/{id}")
    public void eliminar(@PathParam("id") Integer id){
        servicio.eliminar(id);
    }

    //test
    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    public String hola(){
        String msg = "Hola mundo desde review";
        return msg;
    }

}
