package com.programacion.distribuida.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="products")
public class Producto {

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
    @Column(name="price", precision = 10, scale = 2, nullable = false)
    private BigDecimal precio;

    @Getter @Setter
    @Column(name="quantity", nullable = false)
    private Integer cantidad;

    @Getter @Setter
    @Column(name="status", nullable = false)
    private Double estado;

    @Getter @Setter
    @Column(name="salescounter", nullable = false)
    private Integer contadorVentas;

    @Getter @Setter
    @Column(name="created", nullable = false)
    private LocalDate creado;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Categoria categoria;


}