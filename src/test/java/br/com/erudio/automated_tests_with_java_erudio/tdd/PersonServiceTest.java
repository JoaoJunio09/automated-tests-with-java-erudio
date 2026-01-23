package br.com.erudio.automated_tests_with_java_erudio.tdd;

import br.com.erudio.automated_tests_with_java_erudio.domain.model.Person;
import br.com.erudio.automated_tests_with_java_erudio.services.PersonService;
import br.com.erudio.automated_tests_with_java_erudio.services.contract.IPersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PersonServiceTest {

    Person person;

    @BeforeEach
    void setup() {
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
        IPersonService service = new PersonService();

        // When / Act
        Person actual = service.createPerson(person);

        // Then / Assert
        assertNotNull(actual, () -> "The createPerson() should not have returned null!");
    }

    @DisplayName("When Create a Person with Success Should Contains ID in Returned a Person Object")
    @Test
    void testCreatePerson_WhenSuccess_ShouldContainsIDInReturnedPersonObject() {
        // Given / Arrange
        IPersonService service = new PersonService();

        // When / Act
        Person actual = service.createPerson(person);

        // Then / Assert
        assertNotNull(
            actual.getId(),
            () -> "Person ID is Missing!");
    }

    @DisplayName("When Create a Person with Success Should Contains FirstName in Returned a Person Object")
    @Test
    void testCreatePerson_WhenSuccess_ShouldContainsFirstNameInReturnedPersonObject() {
        // Given / Arrange
        IPersonService service = new PersonService();

        // When / Act
        Person actual = service.createPerson(person);

        // Then / Assert
        assertEquals(
            person.getFirstName(),
            actual.getFirstName(),
            () -> "The FirstName is Different!");
    }

    @DisplayName("When Create a Person with Success Should Contains LastName in Returned a Person Object")
    @Test
    void testCreatePerson_WhenSuccess_ShouldContainsLastNameInReturnedPersonObject() {
        // Given / Arrange
        IPersonService service = new PersonService();

        // When / Act
        Person actual = service.createPerson(person);

        // Then / Assert
        assertEquals(
            person.getLastName(),
            actual.getLastName(),
            () -> "The LastName is Different!");
    }

    @DisplayName("When Create a Person with Success Should Contains Address in Returned a Person Object")
    @Test
    void testCreatePerson_WhenSuccess_ShouldContainsAddressInReturnedPersonObject() {
        // Given / Arrange
        IPersonService service = new PersonService();

        // When / Act
        Person actual = service.createPerson(person);

        // Then / Assert
        assertEquals(
            person.getAddress(),
            actual.getAddress(),
            () -> "The Address is Different!");
    }

    @DisplayName("When Create a Person with Success Should Contains Gender in Returned a Person Object")
    @Test
    void testCreatePerson_WhenSuccess_ShouldContainsGenderInReturnedPersonObject() {
        // Given / Arrange
        IPersonService service = new PersonService();

        // When / Act
        Person actual = service.createPerson(person);

        // Then / Assert
        assertEquals(
            person.getGender(),
            actual.getGender(),
            () -> "The Gender is Different!");
    }

    @DisplayName("When Create a Person with Success Should Contains E-mail in Returned a Person Object")
    @Test
    void testCreatePerson_WhenSuccess_ShouldContainsEmailInReturnedPersonObject() {
        // Given / Arrange
        IPersonService service = new PersonService();

        // When / Act
        Person actual = service.createPerson(person);

        // Then / Assert
        assertEquals(
            person.getEmail(),
            actual.getEmail(),
            () -> "The E-mail is Different!");
    }
}