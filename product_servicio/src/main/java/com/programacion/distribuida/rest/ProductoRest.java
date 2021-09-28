package com.programacion.distribuida.rest;

import com.programacion.distribuida.dominio.Producto;
import com.programacion.distribuida.dto.ProductoDto;
import com.programacion.distribuida.servicio.ProductoServicio;
import org.eclipse.microprofile.config.inject.ConfigProperty;

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

    @Inject
    @ConfigProperty(name = "server.port", defaultValue = "8080")
    private Integer port;

    @GET @Path("/ping")
    public String ping(){
        return "OK";
    }

    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    public String hola(){
        return "Hola mundo desde producto";
    }

    //obtiene toda la lista de productos
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductoDto> listar(){
        return servicio.listar();
    }

    //obtiene un producto por id
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProductoDto listarPorId(@PathParam("id") Integer id){
        return servicio.buscarId(id);
    }

    //obtiene todos los productos disponibles
    @GET
    @Path("/disponible")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductoDto> listarDisponibles(){
        return servicio.listarDisponibles();
    }

    //obtiene todos los productos agotados
    @GET
    @Path("/agotado")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductoDto> listarAgotados(){
        return servicio.listarAgostados();
    }

    //crea un nuevo producto
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void crear(ProductoDto productoDto){
        servicio.crear(productoDto);
    }

    //edita un producto
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void editar(Producto producto){
        servicio.editar(producto);
    }

    //elimina un producto
    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Integer id){
        servicio.eliminar(id);
    }

}
