package com.programacion.distribuida.entitites;

import javax.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "orderitem")
public class OrderItem {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "productId")
    private Integer productId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "created")
    private LocalDate created;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}

