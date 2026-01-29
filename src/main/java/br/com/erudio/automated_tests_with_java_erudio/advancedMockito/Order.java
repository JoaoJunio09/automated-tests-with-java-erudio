package br.com.erudio.automated_tests_with_java_erudio.advancedMockito;

import java.time.LocalDateTime;

public class Order {

    private String id;
    private String productName;
    private Long amount;
    private LocalDateTime creationDate;

    public Order() {}

    public Order(String productName, Long amount, String id, LocalDateTime creationDate) {
        this.productName = productName;
        this.amount = amount;
        this.id = id;
        this.creationDate = creationDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
