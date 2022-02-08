package cloud.caravana.algo.pairsum;

import static cloud.caravana.algo.pairsum.PairSum.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class ProgramTest {
    @Test
    void caseNull(){
        int[] array = null;
        int targetSum = 0;
        var result = PairSum.iterTwoNumberSum(array, targetSum);
        assertNull(result);
    }

    static int[] arrayA = new int[]{3, 5, -4, 8, 11, 1, -1, 6};
    static int targetA = 10;

    static int[] arrayXL = new int[999_999_999];
    static int targetXL = 1;

    @BeforeAll
    static void beforeAll(){
        for (int i = 0; i < arrayXL.length; i++) {
            arrayXL[i] = 0;
        }
        arrayXL[arrayXL.length - 1] = 1;
    }

    @Test
    void caseIterA(){
        var result = PairSum.iterTwoNumberSum(arrayA, targetA);
        var r0 = result[0];
        var r1 = result[1];
        assertEquals(10, r0 + r1);
    }

    @Test
    void caseMemoA(){
        var result = memoTwoNumberSum(arrayA, targetA);
        var r0 = result[0];
        var r1 = result[1];
        assertEquals(10, r0 + r1);
    }

    @Test
    void caseTunnelA(){
        var r = tunnelTwoNumberSum(arrayA, targetA);
        assertEquals(10, r[0] + r[1]);
    }

    @Test
    void caseTunnelXL(){
        var r = tunnelTwoNumberSum(arrayXL, targetXL);
        assertEquals(targetXL, r[0] + r[1]);
    }

    @Test
    void caseMemoXL(){
        var r = memoTwoNumberSum(arrayXL, targetXL);
        assertEquals(targetXL, r[0] + r[1]);
    }

    @Test
    void caseIterXL(){
        var r = iterTwoNumberSum(arrayXL, targetXL);
        assertEquals(targetXL, r[0] + r[1]);
    }


    
}
