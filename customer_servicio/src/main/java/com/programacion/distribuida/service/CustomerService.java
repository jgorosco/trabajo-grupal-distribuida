package com.programacion.distribuida.service;

import com.programacion.distribuida.dominio.Customer;
import com.programacion.distribuida.dto.CustomerDto;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class CustomerService {

    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    public static CustomerDto mapToDto(Customer customer) {
        return new CustomerDto(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getAddress(),
                customer.getPhone(),
                customer.getEmail(),
                customer.getSubscriptionDate(),
                customer.isStatus()
        );
    }

    @Transactional
    public void create(CustomerDto customerDto) {
        em.persist(new Customer(customerDto.getFirstName(),
                customerDto.getLastName(),
                customerDto.getAddress(),
                customerDto.getPhone(),
                customerDto.getEmail(),
                customerDto.getSubscriptionDate(),
                customerDto.isStatus()));
    }

    public List<CustomerDto> findAll() {
        return em.createNamedQuery("Customer.findAll", Customer.class)
                .getResultList().stream().map(CustomerService::mapToDto)
                .collect(Collectors.toList());
    }

    public CustomerDto findById(Long id) {
        return mapToDto(em.find(Customer.class, id));
    }

    public List<CustomerDto> findAllActive(){
        return em.createNamedQuery("Customer.findAllActive", Customer.class)
                .getResultList().stream().map(CustomerService::mapToDto)
                .collect(Collectors.toList());
    }

    public List<CustomerDto> findAllInactive(){
        return em.createNamedQuery("Customer.findAllInactive", Customer.class)
                .getResultList().stream().map(CustomerService::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id){
        Customer customer = this.em.find(Customer.class, id);
        customer.setStatus(false);
        this.em.merge(customer);
    }
}
