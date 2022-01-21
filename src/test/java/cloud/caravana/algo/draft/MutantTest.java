package cloud.caravana.algo.draft;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MutantTest {
    @Test
    public void testEmpty(){
        assertTrue(true);
    }    

    @Test
    public void testCaseA(){
        var dna = new String[]{
            "ATGCGA",
            "CAGTGC",
            "TGACGA",
            "CGTAGC",
            "ATGCGA",
            "CAGTGC"};
        var mutant = Mutant.isMutant(dna);
        assertTrue(mutant);
    }

    @Test
    public void testCaseNegative(){
        var dna = new String[]{
            "ATGCGA",
            "CAGTGC",
            "TGACGA",
            "CGTTTC",
            "ATGCGA",
            "CAGTGC"};
        var mutant = Mutant.isMutant(dna);
        assertFalse(mutant);
    }

    @Test
    public void testCaseEmpty(){
        var dna = new String[]{};
        var mutant = Mutant.isMutant(dna);
        assertFalse(mutant);
    }

    @Test
    public void testCaseNull(){
        var mutant = Mutant.isMutant(null);
        assertFalse(mutant);
    }
}
