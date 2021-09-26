package com.programacion.distribuida.servicio;

import com.programacion.distribuida.dominio.Producto;
import com.programacion.distribuida.dto.ProductoDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class ProductoServicioImp implements ProductoServicio {

    @PersistenceContext(name = "productoPU")
    private EntityManager emp;

    @Inject
    private CategoriaServicio categoriaServicio;

    public ProductoDto mapearProductoDto(Producto producto) {
        ProductoDto dto = new ProductoDto();
        dto.setId(producto.getId());
        dto.setCantidad(producto.getCantidad());
        dto.setCategoria(producto.getCategoria().getNombre());
        dto.setCreado(producto.getCreado());
        dto.setDescripcion(producto.getDescripcion());
        dto.setEstado(producto.getEstado());
        dto.setPrecio(producto.getPrecio());
        dto.setContadorVentas(producto.getContadorVentas());
        dto.setNombre(producto.getNombre());
        return dto;
    }

    @Override
    public void crear(Producto producto) {
        emp.persist(producto);
    }

    @Override
    public ProductoDto buscarId(Integer id) {
        Producto producto = emp.find(Producto.class,id);
        return mapearProductoDto(producto);
    }

    @Override
    public List<Producto> listar() {
        List<Producto> listado;
        listado = emp.createQuery("SELECT u FROM Producto u", Producto.class).getResultList();
        return listado;
    }

    @Override
    public List<Producto> listarDisponibles() {
        return emp.createQuery("SELECT c FROM Producto c WHERE c.estado = 'Disponible'", Producto.class).getResultList();
    }

    @Override
    public List<Producto> listarAgostados() {
        return emp.createQuery("SELECT c FROM Producto c WHERE c.estado = 'Agotado'", Producto.class).getResultList();
    }

    @Override
    public Producto editar(Producto producto) {
        emp.merge(producto);
        return producto;
    }

    @Override
    public void eliminar(Integer id) {
        emp.remove(buscarId(id));
    }
}
