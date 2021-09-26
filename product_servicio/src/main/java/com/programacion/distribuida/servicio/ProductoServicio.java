package com.programacion.distribuida.servicio;

import com.programacion.distribuida.dominio.Producto;
import com.programacion.distribuida.dto.ProductoDto;

import java.util.List;

public interface ProductoServicio {

    void crear(Producto producto);
    ProductoDto buscarId(Integer id);
    List<Producto> listar();
    List<Producto> listarDisponibles();
    List<Producto> listarAgostados();
    Producto editar(Producto producto);
    void eliminar(Integer id);

}
