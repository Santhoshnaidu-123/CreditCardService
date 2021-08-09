package com.publicis.sapient.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
@Data
@Entity
@Table(name = "creditcard")
public class CreditCard {
    @Id
    @Column(name="ID")
    private String id;

    @Column(name="OWNER")
    private String owner;

    @Column(name="BALANCE")
    private BigDecimal balance;

    @Column(name="CARD_NUMBER")
    private String cardNumber;

    @Column(name="limit")
    private BigDecimal limit;
}
