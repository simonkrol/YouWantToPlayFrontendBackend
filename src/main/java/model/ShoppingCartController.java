package model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShoppingCartController {

    @Autowired
    private ShopRepository repository;
    @Autowired
    private ProductRepository prodRepository;
    @Autowired
    private ShoppingCartRepository cartRepository;
// MOVED TO INDEX
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
    public String addProductToCart(@RequestParam(value = "amount") int amount,  @PathVariable("cid") long cid,
                                   @PathVariable("id") long id,
                                   @PathVariable("pid") long pid){
        Product product = prodRepository.findById(pid);
        ShoppingCart cart = cartRepository.findById(id);
        if (product.getInventory() < amount || amount <1) {

            return "shop/shopError";
        }
        cart.add(product, amount);
        cartRepository.save(cart);
        product.setInventory(product.getInventory()-amount);
        prodRepository.save(product);

        return "redirect:/";
    }

    @GetMapping("/checkout{cid}")
    public String checkout(@PathVariable("cid") long id){
        ShoppingCart cart = cartRepository.findById(id);
        return "shop/checkout";
    }


}
