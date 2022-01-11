package cloud.caravana.algo.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class HelloTest {
    @Test
    void testCase(){
        String result = Hello.hello();
        assertEquals("Hello World!", result);
    }

}