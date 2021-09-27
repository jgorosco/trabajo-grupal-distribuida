package com.programacion.distribuida.entitites;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="orders")
public class Order {
    @Id
    @Getter
    @Setter
    @Column(name = "id")
    private Integer id;

    @Getter @Setter
    @Column(name = "totalPrice")
    private Double totalPrice;

    @Getter @Setter
    @Column(name="created")
    private LocalDate created;

    @Getter @Setter
    @Column(name = "status")
    private String status;

    @Getter @Setter
    @Column(name = "shipmentAddress")
    private String shipmentAddress;

    @Getter @Setter
    @Column(name = "shipmentDate")
    private LocalDate shipmentDate;

    @Getter @Setter
    @Column(name="payment_id")
    private Integer paymentId;

    @OneToOne
    @JoinColumn(name = "cart_id")
    @Getter @Setter private Cart cart;
}
