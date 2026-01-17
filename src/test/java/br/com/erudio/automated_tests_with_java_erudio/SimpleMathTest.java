package br.com.erudio.automated_tests_with_java_erudio;

import br.com.erudio.automated_tests_with_java_erudio.math.SimpleMath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Math Operations in SimpleMath Class")
class SimpleMathTest {

    // Nomenclatura:
    // test[System Under Test]_[Condition or State Change]_[Expected]
    @Test
    @DisplayName("Test 6.2 + 2 = 8.2")
    void testSum_When_SixDotTwoIsAddedByTwo_ShouldReturnEightDotTwo() {
        // Given / Arrange
        SimpleMath math = new SimpleMath();
        double firstNumber = 6.2D;
        double secondNumber = 2D;
        Double expected = 8.2D;

        // When / Act
        Double actual = math.sum(firstNumber, secondNumber);

        // Then / Assert
        assertEquals(expected, actual, () -> firstNumber + "+" + secondNumber + " did not produce " + expected + "!");
        assertNotEquals(9.2, actual);
        assertNotNull(actual);
    }

    @Test
    @DisplayName("Test 10.5 - 5 = 5.5")
    void testSubtraction() {
        SimpleMath math = new SimpleMath();
        double firstNumber = 10.5D;
        double secondNumber = 5D;

        Double actual = math.subtraction(firstNumber, secondNumber);
        Double expected = 5.5D;

        assertEquals(expected, actual, () -> firstNumber + "-" + secondNumber + " did not produce " + expected + "!");
        assertNotNull(actual);
        assertNotEquals(12D, actual);
    }

    @Test
    @DisplayName("Test 10 * 5 = 50")
    void testMultiplication() {
        SimpleMath math = new SimpleMath();
        double firstNumber = 10.0D;
        double secondNumber = 5D;

        Double actual = math.multiplication(firstNumber, secondNumber);
        Double expected = 50D;

        assertEquals(expected, actual, () -> firstNumber + "x" + secondNumber + " did not produce " + expected + "!");
        assertNotNull(actual);
        assertNotEquals(12D, actual);
    }

    @Test
    @DisplayName("Test Division by Zero")
    void testDivision() {
        SimpleMath math = new SimpleMath();
        double firstNumber = 5D;
        double secondNumber = 5D;

        Double actual = math.division(firstNumber, secondNumber);
        Double expected = 1D;

        assertEquals(expected, actual, () -> firstNumber + "/" + secondNumber + " did not produce " + expected + "!");
        assertNotNull(actual);
        assertNotEquals(12D, actual);
    }

    @Test
    void testDivision_When_FirstNumberIsDividedByZero_ShouldThrowArithmeticException() {
        fail();
    }

    @Test
    @DisplayName("Test (5 + 5) / 2 = 5")
    void testMean() {
        SimpleMath math = new SimpleMath();
        double firstNumber = 5D;
        double secondNumber = 5D;

        Double actual = math.mean(firstNumber, secondNumber);
        Double expected = 5D;

        assertEquals(expected, actual, () -> "("+firstNumber+")" + "+" + "("+secondNumber+")/2" + " did not produce " + expected + "!");
        assertNotNull(actual);
        assertNotEquals(12D, actual);
    }
}
