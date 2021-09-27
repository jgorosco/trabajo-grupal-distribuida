package com.programacion.distribuida.entitites;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@NoArgsConstructor
@Entity
@NamedQuery(name = "Cart.findAll", query = "select c from Cart c")
@Table(name="cart")
public class Cart {
    @Id
    @Getter @Setter
    @SequenceGenerator(name = "cart_local_seq", sequenceName = "cart_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "cart_local_seq")
    @Column(name = "id")
    private Integer id;

    @Getter @Setter
    @Column(name="created")
    private LocalDate created;

    @Getter @Setter
    @Column(name = "customer_id")
    private Integer customerId;
}
