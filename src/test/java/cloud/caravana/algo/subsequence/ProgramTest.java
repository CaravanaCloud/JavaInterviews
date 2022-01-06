package cloud.caravana.algo.subsequence;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import static cloud.caravana.algo.subsequence.Program.isValidSubsequence;

@QuarkusTest
public class ProgramTest {
    @Test
    public void caseA(){
        var array = List.of(5, 1, 22, 25, 6, -1, 8, 10);
        var sequence = List.of(1, 6, -1, 10);
        var result = isValidSubsequence(array, sequence); 
        assertTrue(result);
    }

    @Test
    public void caseB(){
        var array = List.of(5, 1, 22, 25, 6, -1, 8, 10);
        var sequence = List.of(1, 6, -1, 11, 42);
        var result = isValidSubsequence(array, sequence); 
        assertFalse(result);
    }

    @Test
    public void caseNull(){
        var result = isValidSubsequence(null, null); 
        assertFalse(result);
    }

    @Test
    public void case10(){
        var array = List.of(5, 1, 22, 25, 6, -1, 8, 10);
        var sequence = List.of(5, 1, 22, 25, 6, -1, 8, 10, 12);
        var result = isValidSubsequence(array, sequence); 
        assertFalse(result);
    }

    @Test
    public void caseEmpty(){
        var array = new ArrayList<Integer>();
        var sequence = new ArrayList<Integer>();
        var result = isValidSubsequence(array, sequence); 
        assertTrue(result);
    }
}
