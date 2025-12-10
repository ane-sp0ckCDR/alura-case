package br.com.alura.projeto.course;

import br.com.alura.projeto.category.CategoryRepository;
import br.com.alura.projeto.user.Role;
import br.com.alura.projeto.user.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CourseController {

    private final CourseService service;
    private final CourseRepository courseRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    @Autowired
    public CourseController(CourseService service, CourseRepository courseRepository,
                            CategoryRepository categoryRepository, UserRepository userRepository) {
        this.service = service;
        this.courseRepository = courseRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/admin/courses")
    public String list(Model model) {
        List<Course> courses = service.listAllCourses();
        model.addAttribute("courses", courses);
        return "admin/course/list";
    }

    @GetMapping("/admin/course/new")
    public String createForm(Model model) {

        model.addAttribute("formObject", new NewCourseForm());
        model.addAttribute("formAction", "/admin/course/new");
        model.addAttribute("formTitle", "Cadastrar novo curso");
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("instructors", userRepository.findByRole(Role.INSTRUCTOR));

        return "admin/course/form";
    }

    @PostMapping("/admin/course/new")
    public String create(@Valid NewCourseForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("formObject", form);
            model.addAttribute("formAction", "/admin/course/new");
            model.addAttribute("formTitle", "Cadastrar novo curso");
            return "admin/course/form";
        }

        service.createNew(form);
        return "redirect:/admin/courses";
    }

    @GetMapping("/admin/course/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {

        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado: " + id));

        NewCourseForm form = new NewCourseForm(
                course.getName(),
                course.getCode(),
                course.getDescription(),
                course.getCategory().getId().toString(),
                course.getInstructor().getEmail(),
                course.getStatus().name()
        );

        model.addAttribute("formObject", form);
        model.addAttribute("formAction", "/admin/course/edit/" + id);
        model.addAttribute("formTitle", "Editar curso");
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("instructors", userRepository.findByRole(Role.INSTRUCTOR));

        return "admin/course/form";
    }

    @PostMapping("/admin/course/edit/{id}")
    public String update(
            @PathVariable Long id,
            @Valid NewCourseForm form,
            BindingResult result,
            Model model)
    {
        if (result.hasErrors()) {
            model.addAttribute("formObject", form);
            model.addAttribute("formAction", "/admin/course/edit/" + id);
            model.addAttribute("formTitle", "Editar curso");
            return "admin/course/form";
        }

        service.updateData(id, form);
        return "redirect:/admin/courses";
    }

    @PutMapping("/course/{code}/inactive")
    public ResponseEntity<?> updateStatus(@PathVariable("code") String courseCode) {
        service.inactivateCourse(Long.valueOf(courseCode));

        return ResponseEntity.ok("The course was inactivated.");
    }
}
