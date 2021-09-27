package com.programacion.distribuida.servicio;

import com.programacion.distribuida.dominio.Categoria;
import com.programacion.distribuida.dominio.Producto;
import com.programacion.distribuida.dto.ProductoDto;

import java.util.List;

public interface CategoriaServicio {

    void crear(Categoria categoria);
    List<Categoria> listar();
    Categoria listarPorId(Integer id);
    Categoria editar(Categoria categoria);
    void eliminar(Integer id);

}
