package br.com.erudio.automated_tests_with_java_erudio.tdd;

import br.com.erudio.automated_tests_with_java_erudio.introductionAndTdd.model.Person;
import br.com.erudio.automated_tests_with_java_erudio.introductionAndTdd.services.PersonService;
import br.com.erudio.automated_tests_with_java_erudio.introductionAndTdd.services.contract.IPersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonServiceTest {

    IPersonService service;
    Person person;

    @BeforeEach
    void setup() {
        service = new PersonService();
        person = new Person(
        "Keith",
        "Moon",
        "kmoon@erudio.com.br",
        "Wembly - UK",
        "female"
        );
    }

    @DisplayName("When Create a Person with Success Should Returned a Person Object")
    @Test
    void testCreatePerson_WhenSuccess_ShouldReturnPersonObject() {
        // Given / Arrange

        // When / Act
        Person actual = service.createPerson(person);

        // Then / Assert
        assertNotNull(actual, () -> "The createPerson() should not have returned null!");
    }

    @DisplayName("When Create a Person with Success Should Contains Invalid Fields in Returned a Person Object")
    @Test
    void testCreatePerson_WhenSuccess_ShouldContainsInvalidFieldsInReturnedPersonObject() {
        // Given / Arrange

        // When / Act
        Person actual = service.createPerson(person);

        // Then / Assert
        assertNotNull(
            actual.getId(),
            () -> "Person ID is Missing!");
        assertEquals(
            person.getFirstName(),
            actual.getFirstName(),
            () -> "The FirstName is Different!");
        assertEquals(
            person.getLastName(),
            actual.getLastName(),
            () -> "The LastName is Different!");
        assertEquals(
            person.getAddress(),
            actual.getAddress(),
            () -> "The Address is Different!");
        assertEquals(
            person.getGender(),
            actual.getGender(),
            () -> "The Gender is Different!");
        assertEquals(
            person.getEmail(),
            actual.getEmail(),
            () -> "The E-mail is Different!");
    }

    @DisplayName("When Create a Person with null e-Mail Should throw Exception")
    @Test
    void testCreatePerson_WithNullEmail_ShouldThrowIllegalArgumentException() {
        // Given / Arrange
        person.setEmail(null);

        var expectedMessage = "The Person e-Mail is null or empty!";

        // When / Act
        // Then / Assert
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> service.createPerson(person),
            () -> "Empty e-Mail should have cause an IllegalArgumentException!");

        // Then / Assert
        assertEquals(
            expectedMessage,
            exception.getMessage(),
            () -> "Exception error message is incorrect!");
    }
}