package com.programacion.distribuida.services;

import com.programacion.distribuida.dto.OrderDto;

public interface OrderService {
    OrderDto findById(Integer id);
    void create(OrderDto orderDto);
}