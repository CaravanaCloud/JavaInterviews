package cloud.caravana.algo.hello;

import org.junit.jupiter.api.Test;

public class HelloTest {
    @Test
    void testCase(){
        String result = Hello.hello();
        assertEquals("Hello World!", result);
    }

}