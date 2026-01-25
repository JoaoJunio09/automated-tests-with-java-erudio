package br.com.erudio.automated_tests_with_java_erudio.introductionAndTdd.services.contract;

import br.com.erudio.automated_tests_with_java_erudio.introductionAndTdd.model.Person;

public interface IPersonService {

    Person createPerson(Person person);
}