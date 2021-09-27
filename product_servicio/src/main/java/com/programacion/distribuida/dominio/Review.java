package com.programacion.distribuida.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="review")
public class Review {

    @Id
    @Getter @Setter
    @SequenceGenerator(name = "review_local_seq", sequenceName = "review_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "review_local_seq")
    @Column(name="id", nullable = false)
    private Integer id;

    @Getter @Setter
    @Column(name="text", nullable = false)
    private String texto;

    @Getter @Setter
    @Column(name="rating", nullable = false)
    private BigDecimal calificacion;

    @Getter @Setter
    @Column(name="created", nullable = false)
    private LocalDate creado;

    @Getter @Setter
    @Column(name="product_id", nullable = false)
    private Integer productoId;

}
