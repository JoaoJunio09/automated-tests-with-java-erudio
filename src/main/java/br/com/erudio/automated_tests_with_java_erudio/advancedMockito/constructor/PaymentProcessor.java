package br.com.erudio.automated_tests_with_java_erudio.advancedMockito.constructor;

import java.math.BigDecimal;

public class PaymentProcessor {

    private boolean allowForeignCurrencies;
    private String fallbackOption;
    private BigDecimal taxRate;

    public PaymentProcessor() {
        this(false, "DEBIT", new BigDecimal(19.00));
    }

    public PaymentProcessor(String fallbackOption, BigDecimal taxRate) {
        this(false, fallbackOption, taxRate);
    }

    public PaymentProcessor(boolean allowForeignCurrencies, String fallbackOption, BigDecimal taxRate) {
        this.allowForeignCurrencies = allowForeignCurrencies;
        this.fallbackOption = fallbackOption;
        this.taxRate = taxRate;
    }

    public BigDecimal chargeCustomer(String customerId, BigDecimal netPrice) {

        // Any arbitrary implementation
        System.out.println("About to charge customer: " + customerId);
        return BigDecimal.ZERO;
    }

    public String validityPayment(String customerId, double price) {
        if (customerId.equalsIgnoreCase("10")) {
            return "Payment approved!";
        } else {
            throw new IllegalArgumentException("Payment not approved!");
        }
    }
}