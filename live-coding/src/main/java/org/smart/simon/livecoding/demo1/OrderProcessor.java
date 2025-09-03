package org.smart.simon.livecoding.demo1;

import org.smart.simon.livecoding.demo1.cons.PaymentMethod;
import org.smart.simon.livecoding.demo1.model.Order;
import org.smart.simon.livecoding.demo1.model.PaymentResult;
import org.smart.simon.livecoding.demo1.service.InventoryService;
import org.smart.simon.livecoding.demo1.service.PaymentRegistry;

public class OrderProcessor {
    private final InventoryService inventory;
    private final PaymentRegistry payments;

    public OrderProcessor(InventoryService inventory, PaymentRegistry payments) {
        this.inventory = inventory;
        this.payments = payments;
    }

    public boolean process(Order order, PaymentMethod method) {
        if (!inventory.isInStock(order)) return false;

        inventory.reserve(order);

        PaymentResult pr = payments.get(method).order(order);

        return true; //todo return
    }
}
