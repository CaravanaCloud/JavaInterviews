package cloud.caravana.algo.cig;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.List;

import static cloud.caravana.algo.cig.CIGTree.*;
import static cloud.caravana.Util.*;
import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.*;

class CIGPerfTest {
    static List<List<Integer>> input19,
            input07, input10, input30 = null;

    @BeforeAll
    public static void setup(){
        input07 = parseCIGInput("cig/input07.txt");
        input10 = parseCIGInput("cig/input10.txt");
        input19 = parseCIGInput("cig/input19.txt");
        input30 = parseCIGInput("cig/input30.txt");
    }
    
    @Test
    public void testCaseA(){
        var a = List.of(1,5);
        var b = List.of(1,6);
        var c = List.of(2,4);
        var bg = List.of(a,b,c);
        var result = componentsInGraph(bg);
        assertEquals(2, result.get(0));
        assertEquals(3, result.get(1));
    }

    @Test
    public void testCaseB(){
        var bg = List.of(
                List.of(1,6),
                List.of(2,7),
                List.of(3,8),
                List.of(4,9),
                List.of(2,6));
        var result = componentsInGraph(bg);
        assertIterableEquals(List.of(2,4), result);
    }

    @Test
    public void testCase0(){
        var bg = of(
                of(1, 17),
                of(5, 13),
                of(7, 12),
                of(5, 17),
                of(5, 12),
                of(2, 17),
                of(1, 18),
                of(8, 13),
                of(2, 15),
                of(5, 20));
        var result = componentsInGraph(bg);
        assertIterableEquals(of(11,11), result);
    }

    @Test
    public void testCase07(){
        var result = componentsInGraph(input07);
        assertIterableEquals(of(1197, 1197), result);
    }

    @Test
    public void testCase10(){
        var result = componentsInGraph(input10);
        assertIterableEquals(of(1872, 1872), result);
    }

    @Test
    @Timeout(3)
    public void testCase19(){
        var result = componentsInGraph(input19);
        assertIterableEquals(of(2,866), result);
    }

    @Test
    @Timeout(3)
    public void testCase30(){
        var result = componentsInGraph(input30);
        assertIterableEquals(of(2, 1527), result);
    }
}