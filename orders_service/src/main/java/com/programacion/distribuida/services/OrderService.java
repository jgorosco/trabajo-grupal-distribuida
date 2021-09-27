package com.programacion.distribuida.services;

import com.programacion.distribuida.entitites.Order;

import javax.persistence.criteria.CriteriaBuilder;

public interface OrderService {
    Order findById(Integer id);
}
