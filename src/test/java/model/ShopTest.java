package model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class ShopTest {
    private List<String> categories;
    private List<Product> products;
    private Shop shop1;
    @Before
    public void setUp()
    {
        shop1 = new Shop("Shaun", categories, products);
        categories = new ArrayList<String>();
        products = new ArrayList<Product>();
        Product product1 = new Product("Name", "First product", 1, "testPhoto".getBytes(), shop1.getId());
        Product product2 = new Product("Name", "Second product", 1, "testPhoto".getBytes(), shop1.getId());
        products.add(product1);
        products.add(product2);
        categories.add("Air");
        categories.add("Water");

    }
    @Test
    public void testInstantiation()
    {
        assertNotNull(shop1);
    }

    @Test
    public void testShopCategories()
    {
        assertEquals(shop1.getCategories().get(0), "Air" );
        assertEquals(shop1.getCategories().get(1), "Water" );
    }

    @Test
    public void testShopProducts()
    {
        assertEquals(shop1.getProducts().get(0).getDescription(), "First product" );
        assertEquals(shop1.getProducts().get(1).getDescription(), "Second product" );
        assertEquals(shop1.getProducts().get(0).getInventory(), 1 );
        assertEquals(shop1.getProducts().get(1).getInventory(), 1 );
    }

    @After
    public void tearDown()
    {
        products = null;
        categories = null;
        shop1 = null;
    }
}
