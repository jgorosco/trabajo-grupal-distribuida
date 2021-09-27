package com.programacion.distribuida.services;

import com.programacion.distribuida.entitites.Order;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class OrderServiceImpl implements OrderService{
    @PersistenceContext(name = "orderPU")
    private EntityManager em;
    @Override
    public Order findById(Integer id) {
        return em.find(Order.class,id);
    }
}
