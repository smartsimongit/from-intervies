package org.smart.simon.livecoding.demo1.service;

import org.smart.simon.livecoding.demo1.model.Order; 

public interface InventoryService {

    boolean isInStock(Order order);

    void reserve(Order order);
}
