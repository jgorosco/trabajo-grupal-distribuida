package com.programacion.distribuida.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long id;
    private BigDecimal totalPrice;
    private LocalDateTime created;
    private String status;
    private String shipmentAddress;
    private Date shipmentDate;
    private Long paymentId;
    private Set<OrderItem> orderItems;
    private CarDto cart;
}
