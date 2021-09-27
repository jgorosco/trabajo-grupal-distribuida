package com.programacion.distribuida.dto;

import com.programacion.distribuida.entitites.Cart;
import java.time.LocalDate;

public class OrderDto {
    private Integer id;
    private Double totalPrice;
    private LocalDate created;
    private String status;
    private String shipmentAddress;
    private LocalDate shipmentDate;
    private Integer paymentId;
    private Cart cart;
}
