package model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    @Autowired
    private ShopRepository repository;
    @Autowired
    private ProductRepository Prepository;

    @GetMapping("/shops/{id}/products/{pid}")
    public String showProduct(@PathVariable("id") long id, @PathVariable("pid") long pid, Model model) {
        Shop shop = repository.findById(id);
        Product prod = Prepository.findById(pid);
        model.addAttribute("product", prod);
        repository.save(shop);
        Prepository.save(prod);

        return "shop/product";
    }
}
