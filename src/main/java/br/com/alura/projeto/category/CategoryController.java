package br.com.alura.projeto.category;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/admin/categories")
    public String list(Model model) {
        List<CategoryDTO> list = categoryRepository.findAll()
                .stream()
                .map(CategoryDTO::new)
                .toList();

        model.addAttribute("categories", list);

        return "admin/category/list";
    }

    @GetMapping("/admin/category/new")
    public String create(Model model) {
        model.addAttribute("formObject", new NewCategoryForm());
        model.addAttribute("formAction", "/admin/category/new");
        model.addAttribute("formTitle", "Cadastrar nova categoria");

        return "admin/category/newForm";
    }

    @Transactional
    @PostMapping("/admin/category/new")
    public String save(@Valid NewCategoryForm form, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("formObject", form);
            model.addAttribute("formAction", "/admin/category/new");
            model.addAttribute("formTitle", "Cadastrar nova categoria");
            return "admin/category/newForm";
        }

        if (categoryRepository.existsByCode(form.getCode())) {
            result.rejectValue("code", "duplicate", "Código já existe");
            model.addAttribute("formObject", form);
            model.addAttribute("formAction", "/admin/category/new");
            model.addAttribute("formTitle", "Cadastrar nova categoria");
            return "admin/category/newForm";
        }

        categoryRepository.save(form.toModel());
        return "redirect:/admin/categories";
    }


    @GetMapping("/admin/category/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada"));

        EditCategoryForm form = new EditCategoryForm(category);

        model.addAttribute("formObject", form);
        model.addAttribute("formAction", "/admin/category/edit/" + id);
        model.addAttribute("formTitle", "Editar categoria");

        return "admin/category/newForm";
    }

    @Transactional
    @PostMapping("/admin/category/edit/{id}")
    public String update(
            @PathVariable Long id,
            @Valid EditCategoryForm form,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            model.addAttribute("formObject", form);
            model.addAttribute("formAction", "/admin/category/edit/" + id);
            model.addAttribute("formTitle", "Editar categoria");
            return "admin/category/newForm";
        }

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada"));

        form.update(category);

        return "redirect:/admin/categories";
    }
}