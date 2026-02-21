package br.com.erudio.automated_tests_with_java_erudio.advancedMockito.constructor;

import java.math.BigDecimal;

public class CheckoutService {

    public BigDecimal purchaseProduct(String productName, String customerId) {

        PaymentProcessor paymentProcessor = new PaymentProcessor(); // não é uma boa prática criar construtor dentro do método
        return paymentProcessor.chargeCustomer(customerId, BigDecimal.TEN);
    }
}
