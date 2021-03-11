package model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProductTest {

    private Product product;
    @Before
    public void setUp()
    {
        product = new Product("This is the description", 20, "testPhoto".getBytes());
    }

    @After
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
        assertArrayEquals("testPhoto".getBytes(), product.getImage());
    }
}
