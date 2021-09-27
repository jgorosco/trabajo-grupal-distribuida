package com.programacion.distribuida.rest;

import com.programacion.distribuida.client.ProductRestClient;
import com.programacion.distribuida.dto.ProductoDto;
import lombok.Getter;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/test")
public class TestRest {
    @Inject
    @RestClient
    private ProductRestClient productRestClient;

    @GET
    @Path("/{id}")
    public ProductoDto find(@PathParam("id") Integer id){
        return productRestClient.listarPorId(id);
    }
}
