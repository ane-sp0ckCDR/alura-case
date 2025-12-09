package br.com.alura.projeto.course;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    //@Mapping(target = "id", ignore = true)
    Course newCourseFormToCourse(NewCourseForm form);
}
