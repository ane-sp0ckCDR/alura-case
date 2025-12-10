package br.com.alura.projeto.course;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    @Mapping(target = "category", ignore = true)
    @Mapping(target = "instructor", ignore = true)
    @Mapping(target = "inactDate", ignore = true)
    @Mapping(target = "status", ignore = true)
    Course newCourseFormToCourse(NewCourseForm form);

    @Mapping(target = "category", expression = "java(course.getCategory().getCode())")
    @Mapping(target = "instructorEmail", expression = "java(course.getInstructor().getEmail())")
    NewCourseForm courseToNewCourseForm(Course course);

    default String retrieveInstructorEmail(Course course) {
        return course.getInstructor().getEmail();
    }
}
