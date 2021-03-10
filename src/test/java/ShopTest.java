import model.Product;
import model.Shop;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class ShopTest {
    private List<String> categories;
    private List<Product> products;
    @Test
    public void testInstantiation()
    {
        categories = new ArrayList<String>();
        products = new ArrayList<Product>();
        Product product1 = new Product("First product", 1, null);
        Product product2 = new Product("Second product", 1, null);
        products.add(product1);
        products.add(product2);
        categories.add("Air");
        categories.add("Water");
        Shop shop1 = new Shop("Shaun", categories, products);

        assertNotNull(shop1);
        assertEquals(shop1.getCategories().get(0), "Air" );
        assertEquals(shop1.getCategories().get(1), "Water" );
        assertEquals(shop1.getProducts().get(0).getDescription(), "First product" );
        assertEquals(shop1.getProducts().get(1).getDescription(), "Second product" );
        assertEquals(shop1.getProducts().get(0).getInventory(), 1 );
        assertEquals(shop1.getProducts().get(1).getInventory(), 1 );
    }

    @AfterEach
    void tearDown() {
        products = null;
        categories = null;
    }
}