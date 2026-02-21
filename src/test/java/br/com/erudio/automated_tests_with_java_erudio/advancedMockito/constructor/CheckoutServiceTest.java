package br.com.erudio.automated_tests_with_java_erudio.advancedMockito.constructor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.when;

public class CheckoutServiceTest {

    @DisplayName("Test mock object construction")
    @Test
    void testMockObjectConstruction() {
        try (MockedConstruction<PaymentProcessor> mocked = mockConstruction(PaymentProcessor.class,
            (mock, context) -> {
                when(mock.chargeCustomer(anyString(), any(BigDecimal.class)))
                .thenReturn(BigDecimal.TEN);
            })
        ) {
            CheckoutService service = new CheckoutService();
            BigDecimal result = service.purchaseProduct("MackBook Pro", "42");

            assertEquals(BigDecimal.TEN, result);
            assertEquals(1, mocked.constructed().size());
        }
    }
}
