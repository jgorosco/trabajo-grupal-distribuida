package com.programacion.distribuida.services;

import com.programacion.distribuida.dto.CartDto;
import com.programacion.distribuida.entitites.Cart;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CartServiceImpl implements CartService{
    @PersistenceContext(name = "orderPU")
    private EntityManager em;

    public static CartDto mapToDto(Cart cart){
        return new CartDto(
                cart.getId(),
                cart.getCreated(),
                cart.getCustomerId()
        );
    }
    @Override
    public CartDto findById(Integer id) {
        return mapToDto(em.find(Cart.class,id));
    }

    @Override
    public List<CartDto> findAll(){
        Query q = em.createNamedQuery("Cart.findAll");
        List<Cart> carts = q.getResultList();
        return carts.stream().map(CartServiceImpl::mapToDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void createByCustomerId(Integer id) {
        Cart cart = new Cart();
        cart.setCreated(LocalDate.now());
        cart.setCustomerId(id);
        em.persist(cart);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Cart cart = em.find(Cart.class,id);
        em.remove(cart);
    }
}
