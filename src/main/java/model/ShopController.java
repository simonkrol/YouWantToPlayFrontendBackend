package model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShopController {
    @Autowired
    private ShopRepository repository;
    @Autowired
    private ProductRepository Prepository;



    @GetMapping(value={"/", "/shops"})
    public String shopForm(Model model) {
        model.addAttribute("shops", repository.findAll());
        model.addAttribute("shop", new Shop());
        return "shop/index";
    }

    @GetMapping("shops/{id}")
    public String showShop(@PathVariable("id") long id, Model model) {
        Shop shop = repository.findById(id);

        model.addAttribute("shop", shop);
        model.addAttribute("product", new Product());
        return "shop/show";
    }

    @PostMapping("/shops")
    public String createShop(@RequestParam(value = "name") String name) {
        Shop shop = new Shop();
        shop.setName(name);
        repository.save(shop);

        return "redirect:/shops/" + shop.getId();
    }

    @PostMapping("shops/{id}/newProd")
    public String createShop(@RequestParam(value = "description") String desc, @PathVariable("id") long id) {
        Shop shop = repository.findById(id);
        Product prod = new Product();
        shop.addProduct(prod);
        prod.setDescription(desc);
        Prepository.save(prod);

        return "redirect:/" ;
    }
}
