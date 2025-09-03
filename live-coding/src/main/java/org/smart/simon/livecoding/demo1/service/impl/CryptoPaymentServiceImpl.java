package org.smart.simon.livecoding.demo1.service.impl;

import org.smart.simon.livecoding.demo1.cons.PaymentMethod;
import org.smart.simon.livecoding.demo1.model.Order;
import org.smart.simon.livecoding.demo1.model.PaymentResult;
import org.smart.simon.livecoding.demo1.service.PaymentService;

public class CryptoPaymentServiceImpl implements PaymentService {
    @Override
    public PaymentResult order(Order order) {
        System.out.println("Crypto!");
        return new PaymentResult();
    }

    @Override
    public PaymentMethod method() {
        return PaymentMethod.CRYPTO;
    }
}
