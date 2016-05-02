package com.theironyard.clt;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Created by Ultramar on 5/2/16.
 */
@Entity
@Table(name = "purchases")
public class Purchases {
    @Column(nullable = false)
    LocalDateTime purchaseTime;

    @Column(nullable = false)
    Long creditCard;

    @Column(nullable = false)
    Integer cvv;

    @Column(nullable = false)
    String category;

    @ManyToOne
    Customers customers;

    public Purchases(LocalDateTime purchaseTime, Long creditCard, Integer cvv, String category) {
        this.purchaseTime = purchaseTime;
        this.creditCard = creditCard;
        this.cvv = cvv;
        this.category = category;
    }
}
