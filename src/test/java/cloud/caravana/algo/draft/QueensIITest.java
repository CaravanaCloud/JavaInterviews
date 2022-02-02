package cloud.caravana.algo.draft;

import java.util.List;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class QueensIITest {
    @Test
    public void caseA(){
        var n = 5; 
        var k = 3;
        var r_q = 4;
        var c_q = 3;
        var obstacles = of(
            of(5, 5),
            of(4, 2),
            of(2, 3)
        );
        var result = QueensII.queensAttack(n, k, r_q, c_q, obstacles);
        assertEquals(10, result);
    }
    
}
