package org.smart.simon.livecoding.demo1.service.impl;

import org.smart.simon.livecoding.demo1.model.Order;
import org.smart.simon.livecoding.demo1.service.InventoryService;



public class InMemoryInventory implements InventoryService {
    @Override
    public boolean isInStock(Order order) {
        return true;
    }

    @Override
    public void reserve(Order order) {
        System.out.println("Items reserved!");
    }
}
