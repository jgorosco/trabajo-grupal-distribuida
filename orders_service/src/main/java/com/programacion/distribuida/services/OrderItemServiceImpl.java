package com.programacion.distribuida.services;

import com.programacion.distribuida.dto.OrderItemDto;
import com.programacion.distribuida.entitites.OrderItem;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class OrderItemServiceImpl implements OrderItemService {
    @PersistenceContext(name = "orderPU")
    private EntityManager em;

    @Inject
    private OrderService orderService;

    public static OrderItemDto mapToDto(OrderItem orderItem){
        return new OrderItemDto(
                orderItem.getId(),
                orderItem.getProductId(),
                orderItem.getQuantity(),
                orderItem.getCreated(),
                orderItem.getOrder().getId()
        );
    }

    @Override
    public OrderItemDto findById(Integer id) {
        return mapToDto(em.find(OrderItem.class,id));
    }

    @Override
    public List<OrderItemDto> findAll() {
        Query q = em.createNamedQuery("OrderItem.FindAll");
        List<OrderItem> orderItems = q.getResultList();
        return orderItems.stream().map(OrderItemServiceImpl::mapToDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void create(OrderItemDto orderItemDto) {
        OrderItem orderItem = new OrderItem();
        orderItem.setProductId(orderItemDto.getProductId());
        orderItem.setQuantity(orderItemDto.getQuantity());
        orderItem.setCreated(LocalDate.now());
        orderItem.setOrder(orderService.findById(orderItemDto.getOrderId()));
        em.persist(orderItem);
    }

    @Override
    public void delete(OrderItemDto orderItemDto) {
        OrderItem orderItem = em.find(OrderItem.class,orderItemDto.getId());
        em.remove(orderItem);
    }
}
