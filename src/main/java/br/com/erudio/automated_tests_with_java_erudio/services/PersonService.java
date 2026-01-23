package br.com.erudio.automated_tests_with_java_erudio.services;

import br.com.erudio.automated_tests_with_java_erudio.domain.model.Person;
import br.com.erudio.automated_tests_with_java_erudio.services.contract.IPersonService;

import java.util.concurrent.atomic.AtomicLong;

public class PersonService implements IPersonService {

    @Override
    public Person createPerson(Person person) {
        var id = new AtomicLong().incrementAndGet();
        person.setId(id);
        return person;
    }
}
