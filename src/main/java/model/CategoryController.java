package model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CategoryController {
    @Autowired
    private CategoryRepository repository;


    @GetMapping("/categories/{id}")
    public String showCategory(@PathVariable("id") long id, Model model) {
        Category category = repository.findById(id);
        model.addAttribute("category", category);

        return "category/show";
    }

    @GetMapping("/categories")
    public String indexCategory(Model model) {
        model.addAttribute("categories", repository.findAll());
        return "category/index";
    }
}
