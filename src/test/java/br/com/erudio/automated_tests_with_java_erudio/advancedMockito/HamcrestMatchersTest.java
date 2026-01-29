package br.com.erudio.automated_tests_with_java_erudio.advancedMockito;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersTest {

    @Test
    void testHamcrestMatchers() {
        // Given / Arrange
        List<Integer> scores = Arrays.asList(99, 100, 101, 105);

        // When / Act & Then / Assert
        assertThat(scores, hasSize(4));
        assertThat(scores, hasItems(100, 101));
        // verifico se os números são maiores que 98
        assertThat(scores, everyItem(greaterThan(98)));
        // verifico se os números são menores que 106
        assertThat(scores, everyItem(lessThan(106)));

        // Check Strings
        assertThat("", is(emptyString()));
        assertThat(null, is(emptyOrNullString()));

        // Arrays
        Integer[] myArray = {1, 2, 3};
        Integer[] myEmptyArray = {};
        assertThat(myArray, arrayWithSize(3));
        assertThat(myArray, arrayContaining(1, 2, 3));
        assertThat(myArray, arrayContainingInAnyOrder(3, 2, 1));
        assertThat(myEmptyArray, emptyArray());
    }
}
