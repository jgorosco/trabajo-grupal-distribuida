package com.programacion.distribuida.servicio;

import com.programacion.distribuida.dto.Producto;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class ProductoServicioImp implements ProductoServicio {

    @PersistenceContext(name = "distribuida")
    private EntityManager emp;

    @Override
    public void crear(Producto producto) {
        emp.persist(producto);
    }

    @Override
    public Producto buscarId(Integer id) {
        return emp.find(Producto.class,id);
    }

    @Override
    public List<Producto> listar() {
        List<Producto> listado;
        listado = emp.createQuery("SELECT u FROM Producto u", Producto.class).getResultList();
        return listado;
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
