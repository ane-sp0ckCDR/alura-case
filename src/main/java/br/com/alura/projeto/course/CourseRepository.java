package br.com.alura.projeto.course;

import br.com.alura.projeto.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByCategory(Category category);

    @Query(value = """
        SELECT c.name FROM course c
        WHERE c.category = :categoryId
          AND c.status = 'ACTIVE'
        ORDER BY c.id
        LIMIT 4
        """, nativeQuery = true)
    List<String> findTop4ActiveCourseNamesByCategory(Long categoryId);
}
