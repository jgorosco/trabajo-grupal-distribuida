package com.programacion.distribuida.rest;

import com.programacion.distribuida.dto.PaymentDto;
import com.programacion.distribuida.entitites.Payment;
import com.programacion.distribuida.services.PaymentService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
@Path("/payments")
public class PaymentRest {

    @Inject
    private PaymentService paymentService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public PaymentDto findById(@PathParam("id") Integer id){
        return paymentService.findById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PaymentDto> findAll(){
        return paymentService.findAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/enables")
    public List<PaymentDto> findEnables(){
        return paymentService.findEnables();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/disables")
    public List<PaymentDto> findDisables(){
        return paymentService.findDisables();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(PaymentDto paymentDto){
        paymentService.create(paymentDto);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response update(@PathParam("id") Integer id, PaymentDto paymentDto){
        PaymentDto paymentDto1 = findById(id);
        paymentDto1.setCreated(paymentDto.getCreated());
        paymentDto1.setStatus(paymentDto.getStatus());
        paymentService.update(paymentDto1);
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Integer id){
        paymentService.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
