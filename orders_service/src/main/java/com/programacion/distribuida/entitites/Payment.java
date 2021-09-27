package com.programacion.distribuida.entitites;

import javax.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @Column(name="id")
    private Integer id;

    @Column(name = "status")
    private String status;

    @Column(name = "created")
    private LocalDate created;

}
