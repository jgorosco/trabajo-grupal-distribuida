package com.programacion.distribuida.services;

import com.programacion.distribuida.dto.OrderItemDto;
import com.programacion.distribuida.entitites.OrderItem;

import java.util.List;

public interface OrderItemService {
    OrderItemDto findById(Integer Id);
    List<OrderItemDto> findAll();
    void create(OrderItemDto orderItemDto);
    void delete(OrderItemDto orderItemDto);
    List<OrderItem> findItemsByOrderId(Integer orderId);

}