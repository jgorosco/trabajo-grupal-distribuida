package com.programacion.distribuida.rest;

import com.programacion.distribuida.entitites.Cart;
import com.programacion.distribuida.entitites.Order;
import com.programacion.distribuida.services.CartService;
import com.programacion.distribuida.services.OrderService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
@Path("/orders")
public class CartRest {
    @Inject
    private CartService cartService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cart findById(@PathParam("id") Integer id){
        return cartService.findById(id);
    }

}
