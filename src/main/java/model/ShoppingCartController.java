package model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;

@Controller
public class ShoppingCartController {

    @Autowired
    private ShopRepository repository;
    @Autowired
    private ProductRepository prodRepository;
    @Autowired
    private ShoppingCartRepository cartRepository;

//    @GetMapping("/cart/{id}")
//    public String showCart(@PathVariable("id") long id, Model model) {
//        ShoppingCart cart = cartRepository.findById(id);
//        System.out.print("\n\n\n\n\n\n\n\n\n\n\n");
//        for(Integer l: cart.getCart().values()){
//            System.out.print("AAAA");
//            System.out.print(l);
//        }
//        System.out.print("\n\n\n\n\n\n\n\n\n\n\n");
//        return "/cart/{id}";
//    }

    @PostMapping("/shops/{id}/products/{pid}/addToCart")
    public String addProductToCart(@RequestParam(value = "amount") int amount, @PathVariable("id") long id,
                                   @PathVariable("pid") long pid) {
        Product product = prodRepository.findById(pid);
        ArrayList<ShoppingCart> carts = cartRepository.findAll();
        ShoppingCart cart = carts.get(0);

        if (product.getInventory() < amount){
            System.out.print("wowlowlwowlwowlwololol");

            //return "error page";
        }
        cart.add(product, amount);
        cartRepository.save(cart);

        System.out.print("\n\n\n\n\n");
        System.out.print("Added to cart");
        System.out.print("\n\n\n\n\n");

        return "redirect:/";
    }


}
