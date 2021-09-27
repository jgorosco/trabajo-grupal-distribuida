package com.programacion.distribuida.entitites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name = "Payment.All", query = "select p from Payment p")
@NamedQuery(name ="Payment.StatusList", query = "select p from Payment p where p.status= ?1")
@Table(name = "payment")
public class Payment {
    @Id
    @Getter @Setter
    @SequenceGenerator(name = "payment_local_seq", sequenceName = "payment_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "payment_local_seq")
    @Column(name="id")
    private Integer id;

    @Getter @Setter
    @Column(name = "status")
    private String status;

    @Getter @Setter
    @Column(name = "created")
    private LocalDate created;
}
