package br.com.erudio.automated_tests_with_java_erudio.services.contract;

import br.com.erudio.automated_tests_with_java_erudio.domain.model.Person;

public interface IPersonService {

    Person createPerson(Person person);
}