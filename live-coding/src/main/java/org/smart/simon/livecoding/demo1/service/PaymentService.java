package org.smart.simon.livecoding.demo1.service;

import org.smart.simon.livecoding.demo1.cons.PaymentMethod;
import org.smart.simon.livecoding.demo1.model.Order;
import org.smart.simon.livecoding.demo1.model.PaymentResult;

public interface PaymentService {


     PaymentResult order(Order order);
     PaymentMethod method();
}
