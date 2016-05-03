package com.theironyard.clt;

import javax.persistence.*;


@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String eMail;

    public Customer(String name, String eMail) {
        this.name = name;
        this.eMail = eMail;
    }

    public Customer() {
    }

}
