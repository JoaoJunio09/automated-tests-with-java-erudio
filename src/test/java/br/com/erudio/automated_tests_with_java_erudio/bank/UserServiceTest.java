package br.com.erudio.automated_tests_with_java_erudio.bank;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    AccountService accountService;

    @InjectMocks
    UserService service;

    AccountData data;

    static Long userId;
    static Double price;

    @BeforeAll
    static void beforeAll() {
        userId = null;
        price = null;
    }

    @BeforeEach
    void beforeEach() {
        data = new AccountData(LocalDateTime.of(2026, Month.FEBRUARY, 21, 10, 53), 230.0, "jotajota");
    }

    @DisplayName("Test When User Id Is Null Should Throw Illegal Argument Exception")
    @Test
    void testWhenUserIdIsNull_ShouldThrowIllegalArgumentException() {
        assertThrows(
            IllegalArgumentException.class,
            () -> service.makeDepositByUserId(userId, 30.0),
            () -> "User Id is null");
    }

    @DisplayName("Test When User Id Is Null Should Throw Runtime Exception")
    @Test
    void testWhenUserIdIsNull_ShouldThrowRuntimeException() {
        assertThrows(
            RuntimeException.class,
            () -> service.makeDepositByUserId(10L, price),
            () -> "Price is null or Not a Number");
    }

    @DisplayName("Test Should Make Deposit When By User Id The Ten")
    @Test
    void testShouldMakeDeposit_WhenByUserIdTheTen() {
        userId = 10L;
        price = 30.0;

        when(accountService.deposit(userId, 30.0))
            .thenReturn(data);

        var result = service.makeDepositByUserId(10L, 30.0);

        assertEquals(230, result.getPrice());
        assertEquals("jotajota", result.getUsername());
        assertEquals(LocalDateTime.of(2026, Month.FEBRUARY, 21, 10, 53), result.getDatetime());
    }
}
