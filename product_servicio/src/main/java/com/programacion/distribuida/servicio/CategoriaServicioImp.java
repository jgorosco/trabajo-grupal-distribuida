package com.programacion.distribuida.servicio;

import com.programacion.distribuida.dominio.Categoria;
import com.programacion.distribuida.dominio.Producto;
import com.programacion.distribuida.dto.ProductoDto;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class CategoriaServicioImp implements CategoriaServicio {

    @PersistenceContext(name = "productoPU")
    private EntityManager emp;

    @Override
    @Transactional
    public void crear(Categoria categoria) {
        categoria.setCreado(LocalDate.now());
        emp.persist(categoria);
    }

    @Override
    public List<Categoria> listar() {
        return emp.createQuery("SELECT u FROM Categoria u", Categoria.class).getResultList();
    }

    @Override
    public Categoria listarPorId(Integer id) {
        return emp.find(Categoria.class, id);
    }

    @Override
    @Transactional
    public Categoria editar(Categoria categoria) {
        emp.merge(categoria);
        return categoria;
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        emp.remove(id);
    }
}
