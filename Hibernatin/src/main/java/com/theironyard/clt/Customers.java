package com.theironyard.clt;

import javax.persistence.*;

/**
 * Created by Ultramar on 5/2/16.
 */
@Entity
@Table(name = "customers")
public class Customers {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String eMail;

    public Customers(String name, String eMail) {
        this.name = name;
        this.eMail = eMail;
    }
}