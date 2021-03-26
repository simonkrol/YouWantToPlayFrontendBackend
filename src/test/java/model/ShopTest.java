package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.Assert.*;

public class ShopTest {
    private Category cat1, cat2;
    private List<Product> products;
    private Shop shop1;
    @BeforeEach
    public void setUp()
    {
        cat1 = new Category("Water");
        cat2 = new Category("Fire");
        products = new ArrayList<>();
        Product product1 = new Product("First product", 1, "testPhoto".getBytes());
        Product product2 = new Product("Second product", 1, "testPhoto".getBytes());
        products.add(product1);
        products.add(product2);
        shop1 = new Shop("Shaun", products);
    }
    @Test
    public void testInstantiation()
    {
        assertNotNull(shop1);
    }

    @Test
    public void testShopCategories()
    {
        shop1.addCategory(cat1);
        assertTrue(shop1.getCategories().contains(cat1));
        assertFalse(shop1.getCategories().contains(cat2));
        assertTrue(cat1.getLinkedShops().contains(shop1));
    }

    @Test
    public void testShopProducts()
    {
        assertEquals(shop1.getProducts().get(0).getDescription(), "First product" );
        assertEquals(shop1.getProducts().get(1).getDescription(), "Second product" );
        assertEquals(shop1.getProducts().get(0).getInventory(), 1 );
        assertEquals(shop1.getProducts().get(1).getInventory(), 1 );
    }

    @AfterEach
    public void tearDown()
    {
        products = null;
        shop1 = null;
        cat1 = null;
        cat2 = null;
    }
}
