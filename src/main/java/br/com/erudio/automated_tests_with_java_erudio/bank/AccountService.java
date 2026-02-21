package br.com.erudio.automated_tests_with_java_erudio.bank;

import java.time.LocalDateTime;

public class AccountService {

    private Double balance = 200.0;

    public AccountData deposit(Long userId, Double priceDeposit) {
        String username = "";
        if (userId == 10) username = "jotajota";

        balance += priceDeposit;
        return new AccountData(LocalDateTime.now(), balance, username);
    }
}