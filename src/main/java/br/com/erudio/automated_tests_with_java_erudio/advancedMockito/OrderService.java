package br.com.erudio.automated_tests_with_java_erudio.advancedMockito;

import java.time.LocalDateTime;
import java.util.UUID;

public class OrderService {

    public Order createOrder(String productName, Long amount, String orderID) {

        Order order = new Order();

        order.setId(orderID == null ? UUID.randomUUID().toString() : orderID);
        order.setCreationDate(LocalDateTime.now());
        order.setAmount(amount);
        order.setProductName(productName);
        return order;
    }
}
