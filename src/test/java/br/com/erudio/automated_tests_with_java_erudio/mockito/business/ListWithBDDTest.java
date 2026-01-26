package br.com.erudio.automated_tests_with_java_erudio.mockito.business;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class ListWithBDDTest {

    @Test
    void testMockingList_When_SizeIsCalled_ShouldReturn10() {
        // Given / Arrange
        List<?> list = mock(List.class);
        given(list.size()).willReturn(10);

        // When / Act
        // Then / Assert
        assertThat(list.size(), is(10));
    }

    @Test
    void testMockingList_When_SizeIsCalled_ShouldReturnMultipleValues() {
        // Given / Arrange
        List<?> list = mock(List.class);
        given(list.size()).willReturn(10).willReturn(20);

        // When / Act
        // Then / Assert
        assertThat(list.size(), is(10));
        assertThat(list.size(), is(20));
        assertThat(list.size(), is(20));
    }

    @Test
    void testMockingList_When_GetIsCalled_ShouldReturnErudio() {
        // Given / Arrange
        var list = mock(List.class);
        given(list.get(0)).willReturn("Erudio");

        // When / Act
        // Then / Assert
        assertThat(list.get(0), is("Erudio"));
        assertNull(list.get(1));
    }

    @Test
    void testMockingList_When_GetIsCalledWithArgumentMatcher_ShouldReturnErudio() {
        // Given / Arrange
        var list = mock(List.class);

        // If you are using argument matcher, all arguments
        // have to be provided by matchers.
        given(list.get(anyInt())).willReturn("Erudio");

        // When / Act
        // Then / Assert
        assertThat(list.get(anyInt()), is("Erudio"));
    }

    @Test
    void testMockingList_When_ThrowsAnException() {
        // Given / Arrange
        var list = mock(List.class);

        // If you are using argument matcher, all arguments
        // have to be provided by matchers.
        given(list.get(anyInt())).willThrow(new RuntimeException("Foo Bar"));

        // When / Act
        // Then / Assert
        assertThatThrownBy(() -> list.get(anyInt()))
            .isInstanceOf(RuntimeException.class)
            .hasMessage("Foo Bar")
            .hasMessageContaining("Bar");
    }
}
