package cloud.caravana.algo.reverse;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import static cloud.caravana.algo.reverse.ReverseInplace.*;

@QuarkusTest
public class ReverseInplaceTest {
    static final String longStr = " ".repeat(999_999);
    @Test
    public void testOdd() {
        assertEquals("xuxu", reverse("uxux"));
    }

    @Test
    public void testEven() {
        assertEquals("olleh", reverse("hello"));
    }

    @Test
    public void testLong(){
        assertEquals(longStr, reverse(longStr));
    }

    @Test
    public void testNull() {
        assertEquals(null, reverse(null));
    }

    @Test
    public void testEmpty() {
        assertEquals(null, reverse(null));
    }
}
