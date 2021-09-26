package com.programacion.distribuida.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class ProductoDto implements Serializable {

    @Getter @Setter private Integer id;
    @Getter @Setter private String nombre;
    @Getter @Setter private String descripcion;
    @Getter @Setter private BigDecimal precio;
    @Getter @Setter private Integer cantidad;
    @Getter @Setter private String estado;
    @Getter @Setter private Integer contadorVentas;
    @Getter @Setter private LocalDate creado;
    @Getter @Setter private String categoria;

}
