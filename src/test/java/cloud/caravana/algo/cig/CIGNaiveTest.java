package cloud.caravana.algo.cig;

import static cloud.caravana.Util.*;
import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;


class CIGNaiveTest {
    @Test
    public void testCaseA(){
        var a = List.of(1,5);
        var b = List.of(1,6);
        var c = List.of(2,4);
        var bg = List.of(a,b,c);
        var result = CIGNaiveAlgo.componentsInGraph(bg);
        assertIterableEquals(List.of(2,3), result);
    }

    @Test
    public void testCaseB(){
        var bg = List.of(
                List.of(1,6),
                List.of(2,7),
                List.of(3,8),
                List.of(4,9),
                List.of(2,6));
        var result = CIGNaiveAlgo.componentsInGraph(bg);
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
        var result = CIGNaiveAlgo.componentsInGraph(bg);
        assertIterableEquals(of(11,11), result);
    }

    @Test
    ///@Timeout(3)
    public void testCase19(){
        var input19 = parseInput("cig/input19.txt");
        var result = CIGNaiveAlgo.componentsInGraph(input19);
        assertIterableEquals(of(2,866), result);
    }


}