package com.programacion.distribuida.services;

import com.programacion.distribuida.dto.OrderDto;
import com.programacion.distribuida.entitites.Cart;
import com.programacion.distribuida.entitites.Order;
import com.programacion.distribuida.entitites.OrderItem;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class OrderServiceImpl implements OrderService{
    @PersistenceContext(name = "orderPU")
    private EntityManager em;

    @Inject
    private OrderItemService orderItemService;

    public OrderDto mapToDto(Order order){
        List<OrderItem> orderItemList = orderItemService.findItemsByOrderId(order.getId());
        return new OrderDto(
                order.getId(),
                order.getTotalPrice(),
                order.getCreated(),
                order.getStatus(),
                order.getShipmentAddress(),
                order.getShipmentDate(),
                order.getPaymentId(),
                order.getCart().getId(),
                orderItemList
        );

    }
    @Override
    public OrderDto findById(Integer id) {
        return mapToDto(em.find(Order.class,id));
    }

    @Override
    public void create(OrderDto orderDto){
        Order order = new Order();
        order.setTotalPrice(orderDto.getTotalPrice());
        order.setCreated(LocalDate.now());
        order.setStatus(orderDto.getStatus());
        order.setShipmentAddress(orderDto.getShipmentAddress());
        order.setShipmentDate(orderDto.getShipmentDate());
        order.setPaymentId(orderDto.getPaymentId());
        order.setCart(em.find(Cart.class,orderDto.getCartId()));
        em.persist(order);
    }
}
