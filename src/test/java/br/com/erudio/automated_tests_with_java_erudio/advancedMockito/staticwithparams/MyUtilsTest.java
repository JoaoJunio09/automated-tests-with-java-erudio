package br.com.erudio.automated_tests_with_java_erudio.advancedMockito.staticwithparams;

import br.com.erudio.automated_tests_with_java_erudio.staticwithparams.MyUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.eq;

public class MyUtilsTest {

    @DisplayName("Test should mock static method with params")
    @Test
    void testShouldMockStaticMethodWithParams() {
        try (MockedStatic<MyUtils> mockedStatic = Mockito.mockStatic(MyUtils.class)) {
            mockedStatic
                .when(() -> MyUtils.getWelcomeMessage(
                    eq("Erudio"),
                    anyBoolean()
                ))
                .thenReturn("Howdy Erudio");

            String result = MyUtils.getWelcomeMessage("Erudio", false);

            assertEquals("Howdy Erudio", result);
        }
    }
}
