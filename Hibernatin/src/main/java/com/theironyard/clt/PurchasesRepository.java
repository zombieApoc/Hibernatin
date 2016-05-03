package com.theironyard.clt;


import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Ultramar on 5/2/16.
 */
public interface PurchasesRepository extends CrudRepository<Purchase, Integer>{
    List<Purchase> findPurchasesByCategory(String category);
}
