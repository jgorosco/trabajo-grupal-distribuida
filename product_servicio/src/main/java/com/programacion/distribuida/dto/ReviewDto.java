package com.programacion.distribuida.dto;

import com.programacion.distribuida.dominio.Producto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDate;

public class ReviewDto implements Serializable {

    @Getter @Setter
    private Integer id;

    @Getter @Setter
    private String texto;

    @Getter @Setter
    private String calificacion;

    @Getter @Setter
    private LocalDate creado;

    @Getter @Setter
    private String nombreProducto;

}
