package br.com.alura.projeto.course;

import br.com.alura.projeto.user.User;
import br.com.alura.projeto.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository repository;
    private final CourseMapper mapper;
    private final UserService userService;

    @Autowired
    public CourseService(CourseRepository repository, CourseMapper mapper, UserService userService) {
        this.repository = repository;
        this.mapper = mapper;
        this.userService = userService;
    }

    public Course createNew(NewCourseForm form) {
        validateMandatoryFields(form);
        User instructor = userService.verifyAndGetInstructorByEmail(form.getInstructorEmail());
        Course course = mapper.newCourseFormToCourse(form);

        course.setInstructor(instructor);
        course.setStatus(Status.ACTIVE);

        repository.save(course);
        return course;
    }

    private void validateMandatoryFields(NewCourseForm form) {
        if (form.getName().isBlank()) throw new IllegalArgumentException("The course name is mandatory");

        if (form.getCode().isBlank()) throw new IllegalArgumentException("The course code is mandatory");
        validateCourseCode(form.getCode());

        if (form.getDescription().isBlank()) throw new IllegalArgumentException("The course description is mandatory");

        if (form.getInstructorEmail().isBlank()) throw new IllegalArgumentException("The course instructor is mandatory");
    }

    private void validateCourseCode(String code) {
        if (code.length() < 4 || code.length() > 10) {
            throw new IllegalArgumentException("The course name must be between 4 - 10 chars");
        }

        if (!code.matches("^[A-Za-z-]+$")) {
            throw new IllegalArgumentException("The course name may only contain letters and hifen (-).");
        }

        if (code.startsWith("-") || code.endsWith("-") || code.contains("--")) {
            throw new IllegalArgumentException("Invalid course name");
        }
    }

    public List<Course> listAllCourses() {
        //enfeitar
        return repository.findAll();
    }
}
