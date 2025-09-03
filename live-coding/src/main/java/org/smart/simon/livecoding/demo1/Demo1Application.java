package org.smart.simon.livecoding.demo1;

import org.smart.simon.livecoding.demo1.cons.PaymentMethod;
import org.smart.simon.livecoding.demo1.model.Order;
import org.smart.simon.livecoding.demo1.service.impl.CryptoPaymentServiceImpl;
import org.smart.simon.livecoding.demo1.service.impl.InMemoryInventory;
import org.smart.simon.livecoding.demo1.service.InventoryService;
import org.smart.simon.livecoding.demo1.service.PaymentRegistry;
import org.smart.simon.livecoding.demo1.service.impl.PayPalPaymentServiceImpl;

import java.util.Map;


public class Demo1Application {
    //    Задача:
//    У вас есть класс OrderProcessor, который обрабатывает заказы, взаимодействуя с платёжной системой (PaymentService) и проверяя наличие товара (InventoryService).
//    Требования
//    Гибкость: Система должна позволять легко добавлять новые платёжные системы (например, PayPal, криптовалюту) без изменения кода OrderProcessor.
//    Тестируемость: Должна быть возможность тестировать OrderProcessor в изоляции от реальных сервисов.
//    Масштабируемость: Код должен следовать SOLID, избегая жёсткой связанности.
//    Задание:
//    Спроектируйте интерфейсы и классы (Java).
//    Продемонстрируйте внедрение зависимостей (DI).
//    Объясните, как можно добавить ленивую инициализацию PaymentService (например, если его создание — тяжёлая операция).
    public static void main(String[] args) {
        InventoryService inventory = new InMemoryInventory();
        PaymentRegistry registry = new PaymentRegistry(Map.of(
                PaymentMethod.CRYPTO, CryptoPaymentServiceImpl::new,
                PaymentMethod.PAYPAL, PayPalPaymentServiceImpl::new
        ));

        OrderProcessor processor = new OrderProcessor(inventory, registry);
        processor.process(new Order(), PaymentMethod.CRYPTO);
    }
}
