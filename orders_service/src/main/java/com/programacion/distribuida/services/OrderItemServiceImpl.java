package com.programacion.distribuida.services;

import com.programacion.distribuida.client.ProductRestClient;
import com.programacion.distribuida.dto.OrderItemDto;
import com.programacion.distribuida.dto.ProductoDto;
import com.programacion.distribuida.entitites.Order;
import com.programacion.distribuida.entitites.OrderItem;
import com.programacion.distribuida.entitites.Producto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class OrderItemServiceImpl implements OrderItemService {
    @PersistenceContext(name = "orderPU")
    private EntityManager em;

    @Inject
    private OrderService orderService;

    @Inject
    private ProductRestClient productRestClient;

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
        Order order = em.find(Order.class,orderItemDto);
        Double price = order.getTotalPrice();
        ProductoDto productoDto = productRestClient.listarPorId(orderItemDto.getProductId());
        price = price + productoDto.getPrecio().doubleValue();
        order.setTotalPrice(price);
        OrderItem orderItem = new OrderItem();
        orderItem.setProductId(orderItemDto.getProductId());
        orderItem.setQuantity(orderItemDto.getQuantity());
        orderItem.setCreated(LocalDate.now());
        orderItem.setOrder(em.find(Order.class, orderItemDto.getOrderId()));
        em.persist(orderItem);
    }

    @Override
    public void delete(OrderItemDto orderItemDto) {
        Order order = em.find(Order.class,orderItemDto.getOrderId());
        Double price = order.getTotalPrice();
        price = price - em.find(Producto.class,orderItemDto.getProductId()).getPrecio().doubleValue();
        order.setTotalPrice(price);
        OrderItem orderItem = em.find(OrderItem.class,orderItemDto.getId());
        em.remove(orderItem);
    }

    @Override
    public List<OrderItem> findItemsByOrderId(Integer orderId) {
        Query q = em.createNamedQuery("OrderItem.FindByOrderId");
        return q.getResultList();
    }
}
