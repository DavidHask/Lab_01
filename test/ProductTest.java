import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product p1, p2, p3;

    @BeforeEach
    void setUp() {
        p1 = new Product("000005", "Mithril", "Enchanted Dwarven Armor", 3000.0);
    }

    @Test
    void setID() {
        p1.setID("000005");
        assertEquals("000005", p1.getID());
    }

    @Test
    void setName() {
        p1.setName("Mithril");
        assertEquals("Mithril", p1.getName());
    }

    @Test
    void setDescription() {
        p1.setDescription("Enchanted Dwarven Armor");
        assertEquals("Enchanted Dwarven Armor", p1.getDescription());
    }

    @Test
    void setCost() {
        p1.setCost(3000.0);
        assertEquals(3000.0, p1.getCost());
    }

    @Test
    void toCSV() {
        assertEquals("000005, Mithril, Enchanted Dwarven Armor, 3000.0", p1.toCSV());
    }

    @Test
    void testToString() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void testHashCode() {
    }
}