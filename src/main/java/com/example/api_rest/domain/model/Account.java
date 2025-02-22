package com.example.api_rest.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity(name = "tb_account")
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String number;
    private String agency;
    @Column(precision = 2, scale = 13)
    private BigDecimal balance;
    @Column(name = "adicional-limit", precision = 2, scale = 13)
    private BigDecimal limit;


}
