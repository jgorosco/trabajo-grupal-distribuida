package com.programacion.distribuida.resource;

import com.programacion.distribuida.dominio.Customer;
import com.programacion.distribuida.dto.CustomerDto;
import com.programacion.distribuida.service.CustomerService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RequestScoped
@Path("/customers")
public class CustomerResource {

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

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public CustomerDto update(@PathParam("id") Long id, CustomerDto customerDto){
        Customer customer = customerService.findCustomerById(id);
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setPhone(customerDto.getPhone());
        customer.setAddress(customerDto.getAddress());
        customer.setEmail(customerDto.getEmail());
        return this.customerService.update(customer);
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
