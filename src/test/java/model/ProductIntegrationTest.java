package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ShopRepository repository;

    @Autowired
    private ProductRepository Prepository;

    private Product product;
    private Shop shop;

    @BeforeEach
    public void setUp()
    {
//        List<Product> prods = new ArrayList<Product>();
//        shop = new Shop("Amazon", prods);
//        product = new Product("Name","Description", 20, shop.getId(), "aaa");
//        shop.addProduct(product);
//        Prepository.save(product);
//        repository.save(shop);
    }

    @Test
    public void indexShouldReturnAddressBooks() throws Exception
    {
//        String url = "/shops/" + shop.getId() + "/products/" + product.getId();
//        this.mockMvc.perform(get(url)).andExpect(status().isOk())
//                .andReturn().toString().contains("Description");
    }
}
