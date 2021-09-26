package com.programacion.distribuida.servicio;

import com.programacion.distribuida.dominio.Categoria;
import com.programacion.distribuida.dominio.Producto;
import com.programacion.distribuida.dto.ProductoDto;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class CategoriaServicioImp implements CategoriaServicio {

    @PersistenceContext(name = "productoPU")
    private EntityManager emp;

    @Override
    public void crear(Categoria categoria) {
        emp.persist(categoria);
    }

    @Override
    public List<Categoria> listar() {
        return emp.createQuery("SELECT u FROM Categoria u", Categoria.class).getResultList();
    }

    @Override
    public Categoria buscarId(Integer id) {
        return emp.find(Categoria.class, id);
    }

    @Override
    public Categoria editar(Categoria categoria) {
        emp.merge(categoria);
        return categoria;
    }

    @Override
    public void eliminar(Integer id) {
        emp.remove(id);
    }
}
