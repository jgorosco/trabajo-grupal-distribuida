package com.programacion.distribuida.dominio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries({ @NamedQuery(name = "Producto.todos", query = "SELECT u FROM Producto u")})
@Table(name="product")
public class Producto {

    @Id
    @Getter @Setter
    @SequenceGenerator(name = "producto_local_seq", sequenceName = "product_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "producto_local_seq")
    @Column(name="id")
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
    private Boolean estado;

    @Getter @Setter
    @Column(name="salescounter", nullable = false)
    private Integer contadorVentas;

    @Getter @Setter
    @Column(name="created", nullable = false)
    private LocalDate creado;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name="category_id")
    private Categoria categoria;

//    @Getter @Setter
//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
//    @JoinTable(name = "product_review",
//            joinColumns = @JoinColumn(name = "product_id"),
//            inverseJoinColumns = @JoinColumn(name = "review_id"))
//    private List<Review> reviews;

//    @ManyToOne
//    @JoinColumn(name="category_id")
//    private Categoria categoria;

}
