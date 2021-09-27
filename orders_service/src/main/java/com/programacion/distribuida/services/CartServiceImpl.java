package com.programacion.distribuida.services;

import com.programacion.distribuida.entitites.Cart;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class CartServiceImpl implements CartService{
    @PersistenceContext(name = "orderPU")
    private EntityManager em;
    @Override
    public Cart findById(Integer id) {
        return em.find(Cart.class,id);
    }
}
