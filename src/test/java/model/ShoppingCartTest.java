package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.Assert.*;

public class ShoppingCartTest {
    private ShoppingCart cart;
    @BeforeEach
    public void setUp() {
        cart = new ShoppingCart();
    }

    @Test
    public void testInstantiation() {
        assertNotNull(cart);
    }

    @Test
    public void testAddToCart() {
        Product p = new Product("Name","This is the description", 20, "testPhoto".getBytes(), 12L);
        cart.add(p, 5);
        assertEquals((Object) cart.getCart().get(p.getId()), (Object) 5);
    }

    @AfterEach
    public void tearDown() {
        cart = null;
    }
}
