package com.programacion.distribuida.servicio;

import com.programacion.distribuida.dto.Producto;

import java.util.List;

public interface ProductoServicio {

    void crear(Producto producto);
    Producto buscarId(Integer id);
    List<Producto> listar();
    Producto editar(Producto producto);
    void eliminar(Integer id);

}
