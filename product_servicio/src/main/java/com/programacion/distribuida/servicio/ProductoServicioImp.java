package com.programacion.distribuida.servicio;

import com.programacion.distribuida.dominio.Producto;
import com.programacion.distribuida.dto.ProductoDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ProductoServicioImp implements ProductoServicio {

    @PersistenceContext(name = "productoPU")
    private EntityManager emp;

    @Inject
    private ReviewServicio reviewServicio;

    @Inject
    private CategoriaServicio categoriaServicio;

    public ProductoDto mapearProductoDto(Producto producto) {
        ProductoDto dto = new ProductoDto();
        dto.setId(producto.getId());
        dto.setCantidad(producto.getCantidad());
        dto.setCategoria(producto.getCategoria());
        dto.setCreado(producto.getCreado());
        dto.setDescripcion(producto.getDescripcion());
        if(producto.getEstado()){
            dto.setEstado("Disponible");
        }else{
            dto.setEstado("Agotado");
        }
        dto.setPrecio(producto.getPrecio());
        dto.setContadorVentas(producto.getContadorVentas());
        dto.setNombre(producto.getNombre());
        return dto;
    }

    @Override
    @Transactional
    public void crear(ProductoDto productoDto) {

        emp.persist(new Producto(
                productoDto.getId(),
                productoDto.getNombre(),
                productoDto.getDescripcion(),
                productoDto.getPrecio(),
                productoDto.getCantidad(),
                true,
                0,
                LocalDate.now(),
                categoriaServicio.listarPorId(productoDto.getCategoriaId())
        ));
    }

    @Override
    public ProductoDto buscarId(Integer id) {
        Producto producto = emp.find(Producto.class,id);
        ProductoDto productoDto = mapearProductoDto(producto);
        productoDto.setReviews(reviewServicio.listarPorIdProducto(id));
        return productoDto;
    }

    @Override
    public List<ProductoDto> listar() {
        List<Producto> listado;
        listado = emp.createQuery("SELECT u FROM Producto u", Producto.class)
                .getResultList();
        List<ProductoDto> listadoDto = new ArrayList<>();
        for (Producto producto: listado) {
            ProductoDto productoDto = mapearProductoDto(producto);
            productoDto.setReviews(reviewServicio.listarPorIdProducto(producto.getId()));
            listadoDto.add(productoDto);
        }
        return listadoDto;
    }

    @Override
    public List<Producto> listarDisponibles() {
        return emp.createQuery("SELECT c FROM Producto c WHERE c.estado = true", Producto.class)
                .getResultList();
    }

    @Override
    public List<Producto> listarAgostados() {
        return emp.createQuery("SELECT c FROM Producto c WHERE c.estado = false", Producto.class)
                .getResultList();
    }

    @Override
    @Transactional
    public Producto editar(Producto producto) {
        emp.merge(producto);
        return producto;
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        emp.remove(buscarId(id));
    }
}
