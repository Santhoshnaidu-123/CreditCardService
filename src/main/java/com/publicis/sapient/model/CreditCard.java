package com.publicis.sapient.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
@Data
@Entity
@Table(name = "creditcard")
public class CreditCard {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private String id;

    @Column(name="OWNER")
    private String owner;

    @Column(name="BALANCE")
    private BigDecimal balance;

    @Column(name="CARD_NUMBER")
    private String cardNumber;

    @Column(name="CARD_LIMIT")
    private BigDecimal cardLimit;
}
