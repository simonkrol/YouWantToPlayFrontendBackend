package model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class ShopController {
    @Autowired
    private ShopRepository repository;
    @Autowired
    private ProductRepository Prepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ShoppingCartRepository cartRepository;

    @GetMapping(value={"/", "/shops"})
    public String shopForm(Model model) {
        model.addAttribute("shops", repository.findAll());
        model.addAttribute("carts", cartRepository.findAll());
        return "shop/index";
    }

    @GetMapping("shops/new")
    public String newShop(Model model) {
        model.addAttribute("shop", new Shop());
        model.addAttribute("categories", categoryRepository.findAll());
        return "shop/new";
    }

    @GetMapping("shops/{id}")
    public String showShop(@PathVariable("id") long id, Model model) {
        Shop shop = repository.findById(id);

        model.addAttribute("shop", shop);
        model.addAttribute("product", new Product());
        return "shop/show";
    }

    @PostMapping("/shops")
    public String createShop(@RequestParam(value = "name") String name,
                            @RequestParam(value = "id") Optional<List<String>> categories){
        Shop shop = new Shop();
        shop.setName(name);

        for (String s: categories.orElse(new ArrayList<String>()))
        {
            shop.addCategory(categoryRepository.findById(Long.parseLong(s)));
        }
        repository.save(shop);
        return "redirect:/shops/" + shop.getId();
    }

    @PostMapping("shops/{id}/newProd")
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
