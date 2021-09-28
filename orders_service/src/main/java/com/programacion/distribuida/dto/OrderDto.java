package com.programacion.distribuida.dto;

import com.programacion.distribuida.entitites.Cart;
import com.programacion.distribuida.entitites.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    @Getter @Setter
    private Integer id;
    @Getter @Setter
    private Double totalPrice;
    @Getter @Setter
    private LocalDate created;
    @Getter @Setter
    private String status;
    @Getter @Setter
    private String shipmentAddress;
    @Getter @Setter
    private LocalDate shipmentDate;
    @Getter @Setter
    private Integer paymentId;
    @Getter @Setter
    private Integer cartId;
    @Getter @Setter
    private List<OrderItem> orderItems;
}
