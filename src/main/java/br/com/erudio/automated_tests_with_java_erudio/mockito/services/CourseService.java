package br.com.erudio.automated_tests_with_java_erudio.mockito.services;

import java.util.List;

public interface CourseService {

    List<String> retrieveCourses(String student);
    List<String> doSomething(String student);
    void deleteCourse(String course);
}
