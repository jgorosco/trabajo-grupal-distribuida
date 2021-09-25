package com.programacion.distribuida.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="product")
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
    private String estado;

    @Getter @Setter
    @Column(name="salescounter", nullable = false)
    private Integer contadorVentas;

    @Getter @Setter
    @Column(name="created", nullable = false)
    private LocalDate creado;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Categoria categoria;

//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
//    @JoinTable(name = "product_review",
//            joinColumns = @JoinColumn(name = "product_id"),
//            inverseJoinColumns = @JoinColumn(name = "review_id"))
//    private Set<Review> reviews = new HashSet<>();

//    @ManyToOne
//    @JoinColumn(name="category_id")
//    private Categoria categoria;

}
