package br.com.erudio.automated_tests_with_java_erudio.mockito.business;

import br.com.erudio.automated_tests_with_java_erudio.mockito.services.CourseService;

import java.util.ArrayList;
import java.util.List;

// SUT - System (Method) Under Test
public class CourseBusiness {

    // CourseService is a Dependency
    private CourseService service;

    public CourseBusiness(CourseService service) {
        this.service = service;
    }

    public List<String> retrieveCoursesRelatedToSpring(String student) {

        var filteredCourses = new ArrayList<String>();
        if ("Foo Bar".equalsIgnoreCase(student)) return filteredCourses;
        var allCourses = service.retrieveCourses(student);

        for (String course : allCourses) {
            if (course.contains("Spring")) {
                filteredCourses.add(course);
            }
        }

        return filteredCourses;
    }

    public void deleteCoursesNotRelatedToSpring(String student) {

        var allCourses = service.retrieveCourses(student);

        for (String course : allCourses) {
            if (!course.contains("Spring")) {
                service.deleteCourse(course);
            }
        }
    }
}
