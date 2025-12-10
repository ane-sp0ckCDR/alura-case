package br.com.alura.projeto.login;

import br.com.alura.projeto.category.CategoryListResponse;
import br.com.alura.projeto.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class LoginController {

    private final CategoryService categoryService;

    @Autowired
    public LoginController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<CategoryListResponse> categoryList = categoryService.retrieveCategoryData();
        model.addAttribute("categoryList", categoryList);
        //todo realizar o login do usuário

        return "login";
    }
}

