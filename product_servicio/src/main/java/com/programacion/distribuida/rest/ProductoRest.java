package com.programacion.distribuida.rest;

import com.programacion.distribuida.dominio.Producto;
import com.programacion.distribuida.dto.ProductoDto;
import com.programacion.distribuida.servicio.ProductoServicio;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@Path("/productos")
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
    @Produces(MediaType.APPLICATION_JSON)
    public List<Producto> listar(){
        return servicio.listar();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProductoDto listarPorId(@PathParam("id") Integer id){
        return servicio.buscarId(id);
    }

    @GET
    @Path("/disponible")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Producto> listarDisponibles(){
        return servicio.listarDisponibles();
    }

    @GET
    @Path("/agotados")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Producto> listarAgotados(){
        return servicio.listarAgostados();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void crear(Producto producto){
        servicio.crear(producto);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void editar(Producto producto){
        servicio.editar(producto);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Integer id){
        servicio.eliminar(id);
    }


}
