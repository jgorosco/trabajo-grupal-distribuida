package com.programacion.distribuida.entitites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@NamedQuery(name = "OrderItem.FindAll",query = "select oi from OrderItem oi")
@NamedQuery(name="OrderItem.FindByOrderId", query = "select oi from OrderItem oi where oi.order.id= ?1")
@Table(name = "orderitem")
public class OrderItem {
    @Id
    @Getter @Setter
    @Column(name = "id")
    private Integer id;

    @Getter @Setter
    @Column(name = "productId")
    private Integer productId;

    @Getter @Setter
    @Column(name = "quantity")
    private Integer quantity;

    @Getter @Setter
    @Column(name = "created")
    private LocalDate created;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}

