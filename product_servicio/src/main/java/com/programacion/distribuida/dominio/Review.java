package com.programacion.distribuida.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="review")
public class Review {

    @Id
    @Getter @Setter
    @Column(name="id", nullable = false)
    private Integer id;

    @Getter @Setter
    @Column(name="text", nullable = false)
    private String texto;

    @Getter @Setter
    @Column(name="rating", nullable = false)
    private String calificacion;

    @Getter @Setter
    @Column(name="created", nullable = false)
    private LocalDate creado;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Producto categoria;

}
