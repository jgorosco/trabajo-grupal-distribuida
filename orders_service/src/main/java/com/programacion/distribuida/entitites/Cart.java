package com.programacion.distribuida.entitites;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="cart")
public class Cart {
    @Id
    @Getter @Setter
    @Column(name = "id")
    private Integer id;

    @Getter @Setter
    @Column(name="created")
    private LocalDate created;

    @Getter @Setter
    @Column(name = "customer_id")
    private Integer customerId;
}
