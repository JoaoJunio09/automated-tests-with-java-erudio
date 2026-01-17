package br.com.erudio.automated_tests_with_java_erudio;

import br.com.erudio.automated_tests_with_java_erudio.math.SimpleMath;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Math Operations in SimpleMath Class")
class SimpleMathTest {

    SimpleMath math;

    @BeforeAll
    static void setup() {
        System.out.println("Running @BeforeAll method!");
    }

    @AfterAll
    static void cleanup() {
        System.out.println("Running @AfterAll method!");
    }

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

    @Test
    @DisplayName("Test 5 / 5 = 1")
    void testDivision() {

        System.out.println("Running Test Division by Zero");

        double firstNumber = 5D;
        double secondNumber = 5D;

        Double actual = math.division(firstNumber, secondNumber);
        Double expected = 1D;

        assertEquals(expected, actual, () -> firstNumber + "/" + secondNumber + " did not produce " + expected + "!");
        assertNotNull(actual);
        assertNotEquals(12D, actual);
    }

    @Disabled("TODO: We need still work on it!")
    @Test
    @DisplayName("Test Division by Zero")
    void testDivision_When_FirstNumberIsDividedByZero_ShouldThrowArithmeticException() {
        System.out.println("Running Test Division by Zero");
        fail();
    }

    @Test
    @DisplayName("Test (5 + 5) / 2 = 5")
    void testMean() {

        System.out.println("Running Test (5 + 5) / 2 = 5");

        double firstNumber = 5D;
        double secondNumber = 5D;

        Double actual = math.mean(firstNumber, secondNumber);
        Double expected = 5D;

        assertEquals(expected, actual, () -> "("+firstNumber+")" + "+" + "("+secondNumber+")/2" + " did not produce " + expected + "!");
        assertNotNull(actual);
        assertNotEquals(12D, actual);
    }

    @DisplayName("Display Name")
    @Test
    void testABCD_When_XYZ_Should() {
        // Given / Arrange
        // When / Act
        // Then / Assert
    }
}
