package com.programacion.distribuida.client;

import com.programacion.distribuida.dto.OrderDto;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.Optional;

@Path("/api/orders")
@RegisterRestClient
public interface OrdersRestClient {

    @GET
    @Path("/{id}")
    Optional<OrderDto> findById(@PathParam("id") Long id);

    @GET
    @Path("/payment/{id}")
    Optional<OrderDto> findByPaymentId(@PathParam("id") Long id);

    @POST
    OrderDto save(OrderDto orderDto);
}
