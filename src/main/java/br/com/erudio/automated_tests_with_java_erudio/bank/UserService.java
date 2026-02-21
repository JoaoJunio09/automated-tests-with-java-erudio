package br.com.erudio.automated_tests_with_java_erudio.bank;

public class UserService {

    private AccountService service;

    public AccountData makeDepositByUserId(Long userId, Double price) {
        if (userId == null) throw new IllegalArgumentException("User Id is null");
        if (price == null || price.isNaN()) throw new RuntimeException("Price Deposit is null or Not a Number");
        return service.deposit(userId, price);
    }
}
