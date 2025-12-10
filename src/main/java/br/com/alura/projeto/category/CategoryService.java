package br.com.alura.projeto.category;

import br.com.alura.projeto.course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository repository;
    private final CourseRepository courseRepository;

    @Autowired
    public CategoryService(CategoryRepository repository, CourseRepository courseRepository) {
        this.repository = repository;
        this.courseRepository = courseRepository;
    }

    public Category verifyAndGetCategoryById(Long categoryId) {
        return repository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("This category does not exist"));
    }

    public List<CategoryListResponse> retrieveCategoryData() {
        List<Category> categories = repository.findAll();

        return categories.stream().map(category -> {

            List<String> courseNames = courseRepository.findTop4ActiveCourseNamesByCategory(category.getId());
            String coursesString = String.join(", ", courseNames);

            return new CategoryListResponse(
                    category.getName().toUpperCase(),
                    coursesString,
                    category.getColor(),
                    category.getCode()
            );
        })
        .toList();
    }
}
