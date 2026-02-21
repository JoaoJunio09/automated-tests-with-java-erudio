package br.com.erudio.automated_tests_with_java_erudio.bank;

import java.time.LocalDateTime;

public class AccountData {

    private LocalDateTime datetime;
    private Double price;
    private String username;

    public AccountData(LocalDateTime datetime, Double price, String username) {
        this.datetime = datetime;
        this.price = price;
        this.username = username;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
