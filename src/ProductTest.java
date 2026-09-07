import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product product;

    @BeforeEach
    void setUp() {
        product = new Product("Laptop", "Gaming Laptop", "123456", 999.99);
    }

    @Test
    void constructorTest() {
        Product testProduct =
                new Product("Mouse", "Wireless Mouse", "654321", 29.99);

        assertEquals("Mouse", testProduct.getName());
        assertEquals("Wireless Mouse", testProduct.getDescription());
        assertEquals("654321", testProduct.getID());
        assertEquals(29.99, testProduct.getCost());
    }

    @Test
    void setName() {
        product.setName("Computer");
        assertEquals("Computer", product.getName());
    }

    @Test
    void setDescription() {
        product.setDescription("Office Laptop");
        assertEquals("Office Laptop", product.getDescription());
    }

    @Test
    void setCost() {
        product.setCost(899.99);
        assertEquals(899.99, product.getCost());
    }

    @Test
    void toCSV() {
        assertEquals(
                "Laptop,Gaming Laptop,123456,999.99",
                product.toCSV()
        );
    }

    @Test
    void toJSON() {
        assertEquals(
                "{\"name\":\"Laptop\",\"description\":\"Gaming Laptop\",\"ID\":\"123456\",\"cost\":999.99}",
                product.toJSON()
        );
    }

    @Test
    void toXML() {
        assertEquals(
                "<Product><name>Laptop</name><description>Gaming Laptop</description><ID>123456</ID><cost>999.99</cost></Product>",
                product.toXML()
        );
    }

    @Test
    void testToString() {
        assertEquals(
                "Product{name='Laptop', description='Gaming Laptop', ID='123456', cost=999.99}",
                product.toString()
        );
    }

    @Test
    void testEquals() {
        Product sameProduct =
                new Product("Laptop", "Gaming Laptop", "123456", 999.99);

        assertEquals(product, sameProduct);
    }
}