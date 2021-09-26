package com.programacion.distribuida.servicio;

import com.programacion.distribuida.dominio.Review;

import java.util.List;

public interface ReviewServicio {

    Review listarPorId(Integer id);
    List<Review> listarPorIdProducto(Integer productoId);
    List<Review> listar();

}
