package org.smart.simon.livecoding.demo1.service;

import org.smart.simon.livecoding.demo1.cons.PaymentMethod;

import java.util.Map;
import java.util.function.Supplier;

public class PaymentRegistry {

    private final Map<PaymentMethod, Supplier<PaymentService>> suppliers; // лениво
    public PaymentRegistry(Map<PaymentMethod, Supplier<PaymentService>> suppliers) {
        this.suppliers = Map.copyOf(suppliers);
    }

    public PaymentService get(PaymentMethod method) {
        Supplier<PaymentService> s = suppliers.get(method);
        if (s == null) throw new IllegalArgumentException("No payment for " + method);
        return s.get(); // ленивая инициализация
    }

}
