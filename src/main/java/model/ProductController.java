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

        return "products/show";
    }

    @GetMapping("/shops/{id}/products/new")
    public String newProduct(@PathVariable("id") long id, Model model) {
        Shop shop = repository.findById(id);
        model.addAttribute("product", new Product());
        model.addAttribute("shop", shop);
        return "products/new";
    }

    @PostMapping("shops/{id}/products/new")
    public String createProduct(@RequestParam(value = "description") String desc, @RequestParam(value = "name") String name,
                                @RequestParam(value = "inventory") int inv, @RequestParam(value = "imageUrl") String imageUrl, @PathVariable("id") long id) {
        Shop shop = repository.findById(id);
        Product prod = new Product(name, desc, inv, shop.getId(), imageUrl);
        shop.addProduct(prod);
        repository.save(shop);
        Prepository.save(prod);

        return "redirect:/shops/" + shop.getId();
    }
}
