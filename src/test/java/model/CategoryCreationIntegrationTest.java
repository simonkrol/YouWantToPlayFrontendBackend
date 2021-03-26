package model;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CategoryCreationIntegrationTest
{
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ShopRepository repository;


    @BeforeEach
    public void setUp()
    {
        Category category = new Category("Travel");
        List<Product> prods = new ArrayList<Product>();
        Shop shop = new Shop("Amazon", prods);
        shop.addCategory(category);
        repository.save(shop);
    }
    @Test
    public void indexShouldReturnAddressBooks() throws Exception
    {
        this.mockMvc.perform(get("/shops")).andExpect(status().isOk())
                .andReturn().toString().contains("Travel");
    }
}
