package com.programacion.distribuida.servicio;

import com.programacion.distribuida.dominio.Producto;
import com.programacion.distribuida.dto.ProductoDto;

import java.util.List;

public interface ProductoServicio {

    void crear(ProductoDto productoDto);
    ProductoDto buscarId(Integer id);
    List<ProductoDto> listar();
    List<ProductoDto> listarDisponibles();
    List<ProductoDto> listarAgostados();
    Producto editar(Producto producto);
    void eliminar(Integer id);

}
