package cloud.caravana;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class UtilTest {

    @Test
    void linesToArray() {
        var value = """
                A
                B
                C""";
        var actual = Util.linesToArray(value);
        var expected = new String[]{"A","B","C"};
        assertArrayEquals(expected, actual);
    }

    @Test
    void arrayToLines() {
        var value = new int[]{1,2,3};
        var actual = Util.arrayToLines(value);
        var expected = """
                1
                2
                3
                """;
        assertEquals(expected, actual);
    }

    @Test
    void commasToInts() {
        String value = "1,2,3";
        int[] actual = Util.commasToInts(value);
        int[] expected = new int[]{1,2,3};
        assertArrayEquals(actual, expected);
    }

    @Test
    void intsToIntegers() {
        int[] value =  new int[]{1,2,3};
        Integer[] actual = Util.intsToIntegers(value);
        Integer[] expected = new Integer[]{1,2,3};
        assertArrayEquals(actual, expected);
    }

    @Test
    void commasToIntegers() {
        String value = "1,2,3";
        Integer[] actual = Util.commasToIntegers(value);
        Integer[] expected = new Integer[]{1,2,3};
        assertArrayEquals(actual, expected);
    }

    @Test
    void integersToInts() {
        Integer[] value =  new Integer[]{1,2,3};
        int[] actual = Util.integersToInts(value);
        int[] expected = new int[]{1,2,3};
        assertArrayEquals(actual, expected);
    }
}