package com.alessandro.gestionale.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "fees")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Fees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;
    @Column(name="NAME")
    private String name;
    @Column(name="AMOUNT")
    private BigDecimal amount;
    @Column(name="PERIODICITY")
    private String periodicity;
    @Column(name="PAYDAY")
    private Integer payday;
    @Column(name="CLOSING_DATE")
    private LocalDate closingDate;

}

