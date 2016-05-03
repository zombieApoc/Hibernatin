package com.theironyard.clt;


import org.springframework.data.repository.CrudRepository;

/**
 * Created by Ultramar on 5/2/16.
 */
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    public Customer getCustomerById(int id);
}
