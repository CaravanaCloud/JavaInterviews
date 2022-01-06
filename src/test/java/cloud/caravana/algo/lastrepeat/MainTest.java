package cloud.caravana.algo.lastrepeat;

import io.quarkus.test.junit.QuarkusTest;
import static cloud.caravana.algo.lastrepeat.Main.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

@QuarkusTest
public class MainTest {

    @Test
    public void caseA() {
        var input = "abracadabra";
        var output = lastRepeating(input);
        assertEquals("a", output);
    }

    @Test
    public void caseB() {
        var input = "abbc";
        var output = lastRepeating(input);
        assertEquals("b", output);
    }

    @Test
    public void caseC() {
        var input = "abcd";
        var output = lastRepeating(input);
        assertEquals("", output);
    }

    @Test
    public void caseD() {
        var input = "";
        var output = lastRepeating(input);
        assertEquals("", output);
    }

    @Test
    public void caseE() {
        var input = (String) null;
        var output = lastRepeating(input);
        assertEquals( "", output);
    }
}
