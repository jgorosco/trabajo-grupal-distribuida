package com.programacion.distribuida.servicio;

import com.programacion.distribuida.dominio.Review;

import java.util.List;

public interface ReviewServicio {

    List<Review> todosPorIdProducto(Integer productoId);
    List<Review> listar();

}
