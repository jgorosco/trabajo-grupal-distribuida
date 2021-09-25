package com.programacion.distribuida.repository;

import com.programacion.distribuida.dto.CustomerDto;
import com.programacion.distribuida.service.CustomerService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RequestScoped
@Path("/customers")
public class CustomerRepository {

    @Inject
    private CustomerService customerService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CustomerDto> findAll(){
        return this.customerService.findAll();
    }

    @GET
    @Path("/{id}")
    public CustomerDto findById(@PathParam("id") Long id){
        return this.customerService.findById(id);
    }

    @GET
    @Path("/active")
    public List<CustomerDto> findAllActive(){
        return this.customerService.findAllActive();
    }

    @GET
    @Path("/inactive")
    public List<CustomerDto> findAllInactive(){
        return this.customerService.findAllInactive();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(CustomerDto customerDto){
        this.customerService.create(customerDto);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id){
        this.customerService.delete(id);
    }

    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    public String test(){
        return "HOLA MUNDO";
    }
}
