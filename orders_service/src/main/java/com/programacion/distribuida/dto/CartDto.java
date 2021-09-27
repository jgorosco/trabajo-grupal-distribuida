package com.programacion.distribuida.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {
    @Getter @Setter
    private Integer id;
    @Getter @Setter
    private LocalDate created;
    @Getter @Setter
    private Integer customerId;
}
