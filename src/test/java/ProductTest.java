import model.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    private Product product;
    @BeforeEach
    void setUp() {
        product = new Product("This is the description", 20, null);
    }

    @AfterEach
    void tearDown() {
        product = null;
    }

    @Test
    void testDescription(){
        assertNotNull(product.getDescription());
        assertEquals("This is the description", product.getDescription());

        String newDesc = "A new description";
        product.setDescription(newDesc);

        assertEquals(newDesc, product.getDescription());
    }

    @Test
    void testInventory(){
        assertNotNull(product.getInventory());
        assertEquals(20,product.getInventory());

        int newNum = 15;
        product.setInventory(newNum);

        assertEquals(newNum, product.getInventory());
    }

    @Test
    void testImage(){
        assertNull(product.getImage());
    }
}