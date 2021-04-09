package model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class ShoppingCartController {

    @Autowired
    private ShopRepository repository;
    @Autowired
    private ProductRepository prodRepository;
    @Autowired
    private ShoppingCartRepository cartRepository;

    @PostMapping("/shops/{id}/products/{pid}/addToCart")
    public String addProductToCart(@RequestParam(value = "amount") int amount,
                                   @PathVariable("id") long id,
                                   @PathVariable("pid") long pid){
        Product product = prodRepository.findById(pid);

        ArrayList<ShoppingCart> carts = cartRepository.findAll();
        ShoppingCart cart = carts.get(0);
        if (product.getInventory() < amount || amount <1) {
            return "shop/shopError";
        }
        cart.add(product, amount);
        cartRepository.save(cart);
        product.setInventory(product.getInventory()-amount);
        prodRepository.save(product);

        return "redirect:/";
    }

    @PostMapping("/checkout")
    public String checkout(){
        ArrayList<ShoppingCart> carts = cartRepository.findAll();
        ShoppingCart cart = carts.get(0);
        cart.getCart().clear();
        cartRepository.save(cart);
        return "shop/checkout";
    }

    @GetMapping("/cart")
    public String showCart(Model model) {
        ArrayList<ShoppingCart> carts = cartRepository.findAll();
        ShoppingCart cart = carts.get(0);
        HashMap<Product, Integer> shoppingCart = new HashMap<Product, Integer>();
        for (Long key : cart.getCart().keySet())
        {
            shoppingCart.put(prodRepository.findById(key).orElse(new Product()), cart.getCart().get(key));
        }
        model.addAttribute("shoppingCart", shoppingCart);
        return "shop/cart";
    }
}
