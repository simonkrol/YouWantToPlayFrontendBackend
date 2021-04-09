package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ShoppingCartIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ShopRepository repository;

    @Autowired
    private ProductRepository pRepository;

    @Autowired
    private ShoppingCartRepository cartRepository;

    private Product product;
    private Shop shop;
    private ShoppingCart cart;

    @BeforeEach
    public void setUp()
    {
        List<Product> prods = new ArrayList<Product>();
        shop = new Shop("Amazon", prods);
        product = new Product("Name","Description", 20, shop.getId(), "aaa");
        shop.addProduct(product);
        repository.save(shop);
        pRepository.save(product);
        cart = new ShoppingCart();
        cartRepository.save(cart);
    }

    @Test
    public void addToCartShouldRemoveInventory() throws Exception
    {
        String url = "/shops/" + shop.getId() + "/products/" + product.getId() + "/addToCart";
//        this.mockMvc.perform(get(url)).andExpect(status().isOk())
//                .andReturn().toString().contains("Description");
        //Expect to find 5 based on 20 - 5
        this.mockMvc.perform(MockMvcRequestBuilders.post(url).param("amount", "15")).andReturn().toString().contains("5");
    }
}
