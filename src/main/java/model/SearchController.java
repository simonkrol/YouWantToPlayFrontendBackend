package model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {
    @Autowired
    private ShopRepository shopRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    @PostMapping("/search")
    public String search(@RequestParam(value = "query") String query) {
        if(query.length() == 0)
        {
            return "common/not_found";
        }
        return "redirect:/search/" + query;
    }


    @GetMapping("search/{query}")
    public String showSearch(@PathVariable("query") String query, Model model) {
        List<Shop> shops = shopRepository.findByName(query);
        if(shops.size() > 1)
        {
            model.addAttribute("shop", new Shop());
            model.addAttribute("categories", categoryRepository.findAll());
            model.addAttribute("shops", shops);
            return "shop/index";
        }
        else if(shops.size() == 1)
        {
            model.addAttribute("product", new Product());
            model.addAttribute("shop", shops.get(0));
            return "shop/show";
        }
        List<Category> categories = categoryRepository.findByName(query);
        if(categories.size() > 1)
        {
            model.addAttribute("categories", categories);
            return "category/index";
        }
        else if(categories.size() == 1)
        {
            model.addAttribute("category", categories.get(0));
            return "category/show";
        }
        return "common/not_found";
    }
}
