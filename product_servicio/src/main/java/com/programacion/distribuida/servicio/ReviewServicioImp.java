package com.programacion.distribuida.servicio;

import com.programacion.distribuida.dominio.Review;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class ReviewServicioImp implements ReviewServicio{

    @PersistenceContext(name = "productoPU")
    private EntityManager emp;

    @Override
    public Review listarPorId(Integer id) {
        return emp.find(Review.class, id);
    }

    @Override
    public List<Review> listarPorIdProducto(Integer productoId) {
        return emp.createQuery("SELECT u FROM Review u WHERE u.productoId = :id", Review.class)
                .setParameter("id", productoId)
                .getResultList();
    }

    @Override
    public List<Review> listar() {
        return emp.createQuery("SELECT u FROM Review u", Review.class)
                .getResultList();
    }
}
