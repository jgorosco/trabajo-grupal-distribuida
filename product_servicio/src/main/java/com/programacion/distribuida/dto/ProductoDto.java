package com.programacion.distribuida.dto;

import com.programacion.distribuida.dominio.Categoria;
import com.programacion.distribuida.dominio.Review;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class ProductoDto implements Serializable {

    @Getter @Setter private Integer id;
    @Getter @Setter private String nombre;
    @Getter @Setter private String descripcion;
    @Getter @Setter private BigDecimal precio;
    @Getter @Setter private Integer cantidad;
    @Getter @Setter private String estado;
    @Getter @Setter private Integer contadorVentas;
    @Getter @Setter private LocalDate creado;
    @Getter @Setter private Categoria categoria;
    @Getter @Setter private Integer categoriaId;
    @Getter @Setter private List<Review> reviews;

}
