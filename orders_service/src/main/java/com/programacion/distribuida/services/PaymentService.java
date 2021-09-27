package com.programacion.distribuida.services;

import com.programacion.distribuida.dto.PaymentDto;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface PaymentService {
    PaymentDto findById(Integer id);
    List<PaymentDto> findAll();
    List<PaymentDto> findEnables();
    List<PaymentDto> findDisables();
    void delete(Integer id);
    void update(PaymentDto paymentDto);
    void create(PaymentDto paymentDto);
}
