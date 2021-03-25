package model;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ShopCreationIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ShopRepository repository;


    @Before
    public void setUp(){
        List<String> cats;
        List<Product> prods;
        cats = new ArrayList<String>();
        prods = new ArrayList<Product>();
        Shop shop = new Shop("Amazon", cats, prods);
        repository.save(shop);
    }
    @Test
    public void indexShouldReturnAddressBooks() throws Exception {
        this.mockMvc.perform(get("/shops")).andDo(print()).andExpect(status().isOk())
                .andReturn().toString().contains("Amazon");
    }

}
