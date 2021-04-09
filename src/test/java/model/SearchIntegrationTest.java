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

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SearchIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ShopRepository repository;


    @BeforeEach
    public void setUp(){
        List<Product> prods;
        prods = new ArrayList<Product>();
        Shop shop1 = new Shop("Amazon", prods);
        Shop shop2 = new Shop("Indigo", prods);

        repository.save(shop1);
        repository.save(shop2);
    }
    @Test
    public void searchShouldReturnProperShop() throws Exception {
        this.mockMvc.perform(get("/search/Amazon")).andExpect(status().isOk())
                .andReturn().toString().contains("Amazon");
    }
    @Test
    public void searchShouldNotReturnIncorrectShops() throws Exception {
        String result = this.mockMvc.perform(get("/search/Amazon")).andExpect(status().isOk())
                .andReturn().toString();
        assertFalse(result.contains("Indigo"));
    }

}
