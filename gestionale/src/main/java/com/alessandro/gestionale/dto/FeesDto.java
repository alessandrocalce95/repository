package com.alessandro.gestionale.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FeesDto {

    private String name;
    private BigDecimal amount;
    private String periodicity;
    private Integer payday;
    private LocalDate closingDate;

}

