package com.programacion.distribuida.rest;

import com.programacion.distribuida.dominio.Categoria;
import com.programacion.distribuida.dominio.Review;
import com.programacion.distribuida.servicio.CategoriaServicio;
import com.programacion.distribuida.servicio.ProductoServicio;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@Path("/categorias")
public class CategoriaRest {

    @Inject
    private CategoriaServicio servicio;

    //Todas las categorias
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Categoria> todos(){
        return servicio.listar();
    }

    //Obtiene una categoria por id
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Categoria listarPorId(@PathParam("id") Integer id){
        return servicio.listarPorId(id);
    }

    //Crea una categoria
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void crear(Categoria categoria){
        servicio.crear(categoria);
    }

    //Edita una categoria
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void editar(Categoria categoria){
        servicio.editar(categoria);
    }

    //Elimina una categoria
    @DELETE
    @Path("/{id}")
    public void eliminar(@PathParam("id") Integer id){
        servicio.eliminar(id);
    }

    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    public String hola(){
        return "Hola mundo desde categoria";
    }

}
