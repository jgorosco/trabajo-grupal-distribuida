package com.programacion.distribuida.rest;

import com.programacion.distribuida.dto.CartDto;
import com.programacion.distribuida.entitites.Cart;
import com.programacion.distribuida.entitites.Order;
import com.programacion.distribuida.services.CartService;
import com.programacion.distribuida.services.OrderService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
@Path("/carts")
public class CartRest {
    @Inject
    private CartService cartService;
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CartDto findById(@PathParam("id") Integer id){
        return cartService.findById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CartDto> findAll(){
        return cartService.findAll();
    }

    @POST
    @Path("/customer/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(@PathParam("id") Integer id){
        cartService.createByCustomerId(id);
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Integer id){
        cartService.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
