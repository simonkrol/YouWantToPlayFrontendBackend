package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class ProductTest {

    private Product product;
    @BeforeEach
    public void setUp()
    {
        product = new Product("Name","This is the description", 20, "testPhoto".getBytes(), 12L, "https://dpa730eaqha29.cloudfront.net/mltnews/wp-content/uploads/2011/03/Events-in-Seattle-Starbucks-Coffee-Company.jpg");
    }

    @AfterEach
    public void tearDown()
    {
        product = null;
    }

    @Test
    public void testDescription(){
        assertNotNull(product.getDescription());
        assertEquals("This is the description", product.getDescription());

        String newDesc = "A new description";
        product.setDescription(newDesc);

        assertEquals(newDesc, product.getDescription());
    }

    @Test
    public void testInventory(){
        assertNotNull(product.getInventory());
        assertEquals(20,product.getInventory());

        int newNum = 15;
        product.setInventory(newNum);

        assertEquals(newNum, product.getInventory());
    }

    @Test
    public void testImage(){
        assertNotNull(product.getImageUrl());
    }

}
