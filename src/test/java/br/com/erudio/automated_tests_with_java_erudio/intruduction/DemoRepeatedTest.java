package br.com.erudio.automated_tests_with_java_erudio.intruduction;

import br.com.erudio.automated_tests_with_java_erudio.math.SimpleMath;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DemoRepeatedTest {

    SimpleMath math;

    @BeforeEach
    void beforeEachMethod() {
        System.out.println("Running @BeforeEach method!");
        math = new SimpleMath();
    }

    @RepeatedTest(value = 3, name = "{displayName}. Repetition {currentRepetition} of {totalRepetitions}!")
    @DisplayName("Test Division by Zero")
    void testDivision_When_FirstNumberIsDividedByZero_ShouldThrowArithmeticException(
        RepetitionInfo repetitionInfo,
        TestInfo testInfo
    ) {

        System.out.println("Repetition Nº " + repetitionInfo.getCurrentRepetition() +
            " of " + repetitionInfo.getTotalRepetitions());
        System.out.println("Running " + testInfo.getTestMethod().get().getName());
        // Given
        double firstNumber = 6.2D;
        double secondNumber = 0D;

        var expectedMessage = "Impossible to divide by zero!";

        // When & Then
        ArithmeticException actual = assertThrows(ArithmeticException.class, () -> {
            // When & Then
            math.division(firstNumber, secondNumber);
        }, () -> "Division by show throw an ArithmeticException");

        assertEquals(expectedMessage, actual.getMessage(), () -> "Unexpected exception message");
    }
}
