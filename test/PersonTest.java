import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class PersonTest {

    Person p1, p2, p3;

    @BeforeEach
    void setUp() {
        p1 = new Person("000001", "David", "Tester1", "Mr.", 2004);
        p2 = new Person("0001", "Haskell", "Tester2", ".rM", 4002);
        p3 = new Person("000011", "Bilbo", "Tester3", "Esq.", 1060);
    }

    @Test
    void setID() {
        p1.setID("000001");
        assertEquals("000001", p1.getID());
    }

    @Test
    void setFirstName() {
        p1.setFirstName("David");
        assertEquals("David", p1.getFirstName());
    }

    @Test
    void setLastName() {
        p1.setLastName("Haskell");
        assertEquals("Haskell", p1.getLastName());
    }

    @Test
    void setTitle() {
        p1.setTitle("Mr.");
        assertEquals("Mr.", p1.getTitle());
    }

    @Test
    void setYOB() {
        p1.setYOB(2004);
        assertEquals(2004, p1.getYOB());
    }

    @Test
    void getFullName() {
        p1.setFirstName("David");
        p1.setLastName("Haskell");
        assertEquals("David Haskell", p1.getFullName());
    }

    @Test
    void getFormalName() {
        p1.setFirstName("David");
        p1.setLastName("Haskell");
        p1.setTitle("Mr.");
        assertEquals("Mr. David Haskell", p1.getFormalName());
    }

    @Test
    void getAge() {
        p1.setYOB(2004);
        assertEquals(21, p1.getAge());
    }

    @Test
    void testGetAge() {
        p1.setYOB(2004);
        assertEquals(21, p1.getAge(2025));
    }

    @Test
    void toCSV() {
        assertEquals("000001, David, Tester1, Mr., 2004", p1.toCSV());
    }

    @Test
    void toJSON() {
        assertEquals("{\"people\":[{ \"ID\":\"000001\", \"firstName\":\"David\", \"lastName\":\"Tester1\", \"title\":" +
                "\"Mr.\", \"YOB\":2004 } ]}", p1.toJSON());
    }

    @Test
    void toXML() {
        assertEquals("<people> <person> <ID>000001</ID> <firstName>David</firstName> <lastName>" +
                "Tester1</lastName> <title>Mr.</title> <YOB>2004</YOB> </person> </people>", p1.toXML());
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