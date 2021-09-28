package com.programacion.distribuida.servicio;

import com.programacion.distribuida.dominio.Review;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class ReviewServicioImp implements ReviewServicio{

    @PersistenceContext
    private EntityManager emp;

    @Override
    @Transactional
    public void crear(Review review) {
        review.setCreado(LocalDate.now());
        emp.persist(review);
    }

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

    @Override
    @Transactional
    public void editar(Review review) {
        emp.merge(review);
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        emp.remove(listarPorId(id));
    }
}
