package com.programacion.distribuida.dominio;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Entity
@NamedQueries({
        @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
        @NamedQuery(name = "Customer.findAllActive", query = "SELECT c FROM Customer c WHERE c.status = true"),
        @NamedQuery(name = "Customer.findAllInactive", query = "SELECT c FROM Customer c WHERE c.status = true")
})
@Table(name = "customer")
public class Customer extends AbstractEntity{

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "phone",precision = 10)
    private String phone;

    @Email
    @Column(name = "email", precision = 25)
    private String email;

    @Column(name = "subscriptiondate")
    private Date subscriptionDate;

    @Column(name = "status")
    private boolean status;

}
