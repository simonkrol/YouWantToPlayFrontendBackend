package model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryTest {
    private Category cat;
    private Shop shop;
    private final String CAT_NAME = "TEST_STRING";
    @Before
    public void setUp()
    {
        cat = new Category(CAT_NAME);
        shop = new Shop();

    }
    @Test
    public void testInstantiation()
    {
        assertNotNull(cat);
    }

    @Test
    public void testCategoryName()
    {
        assertEquals(cat.getName(), CAT_NAME );
    }

    @Test
    public void testShopAdd()
    {
        assertFalse(cat.getLinkedShops().contains(shop));
        cat.addLinkedShop(shop);
        assertTrue(cat.getLinkedShops().contains(shop));
    }

    @Test
    public void testGetLinkedShopsImmutability()
    {
        assertEquals(0, cat.getLinkedShops().size());
        cat.getLinkedShops().add(shop);
        assertEquals(0, cat.getLinkedShops().size());
    }

    @After
    public void tearDown()
    {
        cat = null;
        shop = null;
    }
}
