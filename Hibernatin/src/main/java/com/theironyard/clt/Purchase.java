package com.theironyard.clt;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "purchases")
public class Purchase {

    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    LocalDateTime purchaseTime;

    @Column(nullable = false)
    String creditCard;

    @Column(nullable = false)
    Integer cvv;

    @Column(nullable = false)
    String category;

    @ManyToOne
    Customer customer;

    public Purchase() {
    }

    public Purchase(LocalDateTime purchaseTime, String creditCard, Integer cvv, String category, Customer customer) {
        this.purchaseTime = purchaseTime;
        this.creditCard = creditCard;
        this.cvv = cvv;
        this.category = category;
        this.customer = customer;
    }
}
