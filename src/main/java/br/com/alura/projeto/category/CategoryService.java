package br.com.alura.projeto.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    @Autowired
    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public Category verifyAndGetCategoryById(Long categoryId) {
        return repository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("This category does not exist"));
    }
}
