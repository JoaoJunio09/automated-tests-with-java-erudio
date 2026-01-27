package br.com.erudio.automated_tests_with_java_erudio.mockito.services;

import br.com.erudio.automated_tests_with_java_erudio.mockito.Student;

import java.util.List;

public interface CourseService {

    List<String> retrieveCourses(String student);
    List<String> doSomething(String student);
    List<Student> findAllStudents();
    void deleteCourse(String course);
    void checkStudent(String token);
}
