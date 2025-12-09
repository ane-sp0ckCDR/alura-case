package br.com.alura.projeto.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CourseController {

    private final CourseService service;

    @Autowired
    public CourseController(CourseService service) {
        this.service = service;
    }

    @GetMapping("/admin/courses")
    public ResponseEntity<List<Course>> list() {
        List<Course> response = service.listAllCourses();

        if (response == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(response);
    }

    @PostMapping("/admin/course/new")
    public ResponseEntity<Course> create(@RequestBody NewCourseForm form) {
        Course response = service.createNew(form);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/course/{code}/inactive")
    public ResponseEntity<?> updateStatus(@PathVariable("code") String courseCode) {
        service.inactivateCourse(Long.valueOf(courseCode));

        return ResponseEntity.ok("The course was inactivated.");
    }

}
