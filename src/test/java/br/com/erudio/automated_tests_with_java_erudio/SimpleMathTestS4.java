package br.com.erudio.automated_tests_with_java_erudio;

import br.com.erudio.automated_tests_with_java_erudio.math.SimpleMath;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Math Operations in SimpleMath Class")
class SimpleMathTestS4 {

    SimpleMath math;

    @BeforeEach
    void beforeEachMethod() {
        System.out.println("Running @BeforeEach method!");
        math = new SimpleMath();
    }

    @AfterEach
    void afterEachMethod() {
        System.out.println("Running @AfterEach method!");
    }

    // Nomenclatura:
    // test[System Under Test]_[Condition or State Change]_[Expected]
    @Test
    @DisplayName("Test 6.2 + 2 = 8.2")
    void testSum_When_SixDotTwoIsAddedByTwo_ShouldReturnEightDotTwo() {

        System.out.println("Running Test 6.2 + 2 = 8.2");

        // Given / Arrange
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

        System.out.println("Running Test 10.5 - 5 = 5.5");

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

        System.out.println("Running Test 10 * 5 = 50");

        double firstNumber = 10.0D;
        double secondNumber = 5D;

        Double actual = math.multiplication(firstNumber, secondNumber);
        Double expected = 50D;

        assertEquals(expected, actual, () -> firstNumber + "x" + secondNumber + " did not produce " + expected + "!");
        assertNotNull(actual);
        assertNotEquals(12D, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = { "Pelé", "Senna", "Keith Moon" })
    void testValueSource(String firstName) {
        assertNotNull(firstName);
    }

    @DisplayName("Test double subtraction [firstNumber, secondNumber, expected]")
    @ParameterizedTest
    // @MethodSource("testDivisionInputParameters")
    // @MethodSource
    /*
    @CsvSource({
        "6.2, 2, 3.1",
        "71, 14, 5.07",
        "18.3, 3.1, 5.90"
    })

    @CsvSource({
        "Pelé, Football",
        "Senna, F1",
        "Keith Moon, ''"
    })
    */
    @CsvFileSource(resources = "/testDivision.csv")
    void testDivision(double firstNumber, double secondNumber, double expected) {

        Double actual = math.division(firstNumber, secondNumber);

        assertEquals(expected, actual, 2D, () -> firstNumber + "/" + secondNumber + " did not produce " + expected + "!");
        assertNotNull(actual);
        assertNotEquals(12D, actual);
    }

    /*
    public static Stream<Arguments> testDivision() {
        return Stream.of(
            Arguments.of(6.2D, 2D, 3.1D),
            Arguments.of(71D, 14D, 5.07D),
            Arguments.of(18.3D, 3.1D, 5.90D)
        );
    }
    */
}
