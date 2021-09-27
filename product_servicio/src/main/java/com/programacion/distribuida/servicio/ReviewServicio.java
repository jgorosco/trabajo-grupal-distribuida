package com.programacion.distribuida.servicio;

import com.programacion.distribuida.dominio.Review;

import java.util.List;

public interface ReviewServicio {

    void crear(Review review);
    Review listarPorId(Integer id);
    List<Review> listarPorIdProducto(Integer productoId);
    List<Review> listar();
    void editar(Review review);
    void eliminar (Integer id);


}
