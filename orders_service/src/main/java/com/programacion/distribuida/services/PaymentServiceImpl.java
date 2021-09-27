package com.programacion.distribuida.services;

import com.programacion.distribuida.dto.PaymentDto;
import com.programacion.distribuida.entitites.Payment;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.ws.rs.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class PaymentServiceImpl implements PaymentService{

    @PersistenceContext(name = "orderPU")
    private EntityManager em;

    public static PaymentDto maptoDto(Payment payment){
        return new PaymentDto(
                payment.getId(),
                payment.getStatus(),
                payment.getCreated()
        );
    }

    @Override
    public PaymentDto findById(Integer id) {
        return maptoDto(em.find(Payment.class,id));
    }

    @Override
    public List<PaymentDto> findAll() {
        Query q = em.createNamedQuery("Payment.All");
        List<Payment> paymentList = q.getResultList();
        return paymentList.stream().map(PaymentServiceImpl::maptoDto).collect(Collectors.toList());
    }

    @Override
    public List<PaymentDto> findEnables() {
        Query q = em.createNamedQuery("Payment.StatusList");
        List<Payment> paymentList= q.setParameter(1,"true").getResultList();
        return paymentList.stream().map(PaymentServiceImpl::maptoDto).collect(Collectors.toList());
    }

    @Override
    public List<PaymentDto> findDisables() {
        Query q = em.createNamedQuery("Payment.StatusList");
        List<Payment> paymentList= q.setParameter(1,"false").getResultList();
        return paymentList.stream().map(PaymentServiceImpl::maptoDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Payment payment = em.find(Payment.class,id);
        em.remove(payment);
    }

    @Override
    @Transactional
    public void update(PaymentDto paymentDto) {
        Payment payment = em.find(Payment.class,paymentDto.getId());
        payment.setCreated(paymentDto.getCreated());
        payment.setStatus(paymentDto.getStatus());
        em.merge(payment);
    }

    @Override
    @Transactional
    public void create(PaymentDto paymentDto){
        Payment payment = new Payment();
        payment.setCreated(LocalDate.now());
        payment.setStatus(paymentDto.getStatus());
        em.persist(payment);
    }
}
