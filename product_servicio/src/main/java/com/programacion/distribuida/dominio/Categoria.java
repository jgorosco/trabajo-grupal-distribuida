package com.programacion.distribuida.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="category")
public class Categoria {

    public Categoria(){}

    @Id
    @Getter @Setter
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", nullable = false)
    private Integer id;

    @Getter @Setter
    @Column(name="name", nullable = false)
    private String nombre;

    @Getter @Setter
    @Column(name="description", nullable = false)
    private String descripcion;

    @Getter @Setter
    @Column(name="created", nullable = false)
    private LocalDate creado;

}
