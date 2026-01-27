package br.com.erudio.automated_tests_with_java_erudio.mockito.business;

import br.com.erudio.automated_tests_with_java_erudio.mockito.Student;
import br.com.erudio.automated_tests_with_java_erudio.mockito.services.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

class CourseBusinessMockWithBDDTest {

    CourseService mockService;
    CourseBusiness business;
    List<String> courses;
    List<Student> students;

    @BeforeEach
    void setup() {
        // Given / Arrange
        mockService = mock(CourseService.class);
        business = new CourseBusiness(mockService);

        courses = Arrays.asList(
            "REST API's RESTFul do 0 à Azure com ASP.NET Core 5 e Docker",
            "Agile Desmistificado com Scrum, XP, Kanban e Trello",
            "Spotify Engineering Culture Desmistificado",
            "REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker",
            "Docker do Zero à Maestria - Contêinerização Desmistificada",
            "Docker para Amazon AWS Implante Apps Java e .NET com Travis CI",
            "Microsserviços do 0 com Spring Cloud, Spring Boot e Docker",
            "Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#",
            "REST API's RESTFul do 0 à AWS com Spring Boot 3 Kotlin e Docker",
            "Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android",
            "Microsserviços do 0 com Spring Cloud, Kotlin e Docker"
        );

        students = Arrays.asList(
            new Student(1L, "Joao Junio", 17, "token123"),
            new Student(2L, "Joao", 17, "token12"),
            new Student(3L, "Lucas", 16, "token1234"),
            new Student(4L, "Marina", 17, "321token"),
            new Student(5L, "Maria Fernanda", 17, "123token"),
            new Student(6L, "Fernando", 18, "token321"),
            new Student(7L, "Gabriel", 16, "token")
        );
    }

    @Test
    void testCoursesRelatedToSpring_When_UsingAMock() {
        // Given / Arrange
        given(mockService.retrieveCourses("Leandro"))
            .willReturn(courses);

        // When / Act
        var filteredCourses = business.retrieveCoursesRelatedToSpring("Leandro");

        // Then / Assert
        assertThat(filteredCourses.size(), is(4));
    }

    @DisplayName("Delete Courses not Related to Spring Using Mockito should call Method deleteCourse")
    @Test
    void testCoursesNotRelatedToSpring_UsingMockitoVerify_ShouldCallMethod_DeleteCourses() {
        // Given / Arrange
        given(mockService.retrieveCourses("Leandro"))
            .willReturn(courses);

        // When / Act
        business.deleteCoursesNotRelatedToSpring("Leandro");

        // Then / Assert
        // verify(mockService)
            // .deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");
        // verify(mockService, times(1))
            // .deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");
        // verify(mockService, atLeast(1))
        verify(mockService, atLeastOnce())
            .deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");
        verify(mockService)
            .deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");
        verify(mockService, never())
            .deleteCourse("Microsserviços do 0 com Spring Cloud, Spring Boot e Docker");
    }

    @DisplayName("Delete Courses not Related to Spring Using Mockito should call Method deleteCourse V2")
    @Test
    void testCoursesNotRelatedToSpring_UsingMockitoVerify_ShouldCallMethod_DeleteCoursesV2() {
        // Given / Arrange
        String agileCourse = "Agile Desmistificado com Scrum, XP, Kanban e Trello";
        String architectureCourse = "Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#";
        String restSpringCourse = "Microsserviços do 0 com Spring Cloud, Spring Boot e Docker";

        given(mockService.retrieveCourses("Leandro"))
            .willReturn(courses);

        // When / Act
        business.deleteCoursesNotRelatedToSpring("Leandro");

        then(mockService).should().deleteCourse(agileCourse);
        then(mockService).should().deleteCourse(architectureCourse);
        then(mockService).should(never()).deleteCourse(restSpringCourse);
    }

    @DisplayName("Delete Courses not Related to Spring Capturing Arguments should call Method deleteCourse")
    @Test
    void testCoursesNotRelatedToSpring_CapturingArguments_ShouldCallMethod_DeleteCoursesV2() {
        // Given / Arrange

        /*
        courses = Arrays.asList(
            "Agile Desmistificado com Scrum, XP, Kanban e Trello",
            "REST API's RESTFul do 0 à AWS com Spring Boot 3 Kotlin e Docker"
        );
        */

        given(mockService.retrieveCourses("Leandro"))
            .willReturn(courses);

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

        String agileCourse = "Agile Desmistificado com Scrum, XP, Kanban e Trello";

        // When / Act
        business.deleteCoursesNotRelatedToSpring("Leandro");

        then(mockService).should(times(7)).deleteCourse(argumentCaptor.capture());
        assertThat(argumentCaptor.getAllValues().size(), is(7));
    }

    @DisplayName("Checks if the Token Exists And Verifies if it is Valid")
    @Test
    void testCheckStudent_WhenTheTokenExists_ShouldMustCheckIfTheTokenIsValid() {
        // Given / Arrange
        given(mockService.findAllStudents()).willReturn(students);

        var token = "token123";
        var studentName = "Joao Junio";

        // When / Act
        business.checkStudentByToken(token);

        // Then / Assert
        verify(mockService, atLeastOnce()).checkStudent(studentName);
    }

    @DisplayName("Check if the Student List Size is 7")
    @Test
    void testCheckStudent_ShouldBeVerifiedWhetherTheStudentListSizeIs7() {
        // Given / Arrange
        given(mockService.findAllStudents()).willReturn(students);

        var token = "token123";
        for (Student student : students) student.setToken(token);

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

        // When / Act
        business.checkStudentByToken(token);

        // Then / Assert
        verify(mockService, times(7)).checkStudent(argumentCaptor.capture());
        assertThat(argumentCaptor.getAllValues().size(), is(7));
    }
}