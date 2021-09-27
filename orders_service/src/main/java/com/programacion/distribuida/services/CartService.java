package com.programacion.distribuida.services;

import com.programacion.distribuida.dto.CartDto;
import com.programacion.distribuida.entitites.Cart;

import java.util.List;
public interface CartService {
    CartDto findById(Integer id);
    List<CartDto> findAll();
    void createByCustomerId(Integer id);
    void delete(Integer id);
}
