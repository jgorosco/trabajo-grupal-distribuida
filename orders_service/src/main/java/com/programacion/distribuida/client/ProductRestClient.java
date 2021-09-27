package com.programacion.distribuida.client;

import com.programacion.distribuida.dto.ProductoDto;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RegisterRestClient(baseUri = "http://localhost:9090")
@Path("/productos")
public interface ProductRestClient {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<ProductoDto> listar();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    ProductoDto listarPorId(@PathParam("id") Integer id);
}
