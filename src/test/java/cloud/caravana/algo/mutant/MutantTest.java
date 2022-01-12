package cloud.caravana.algo.mutant;

import io.quarkus.test.junit.QuarkusTest;

import static cloud.caravana.algo.mutant.Mutant.isMutant;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

@QuarkusTest
public class MutantTest {
    
    @Test
    public void testPositiveRight(){
        var dna = new String[]{
            "ATGCGA", 
            "CAGTGC", 
            "TTATGT", 
            "TACCCA", 
            "CCCCTA", 
            "TCACTG"};
        assertTrue(isMutant(dna));
    }

    @Test
    public void testPositiveDown(){
        var dna = new String[]{
            "ATGCGA", 
            "CAGTGC", 
            "TTATGT", 
            "TACCGA", 
            "CCCCGA", 
            "TCACTG"};
        assertTrue(isMutant(dna));
    }

    @Test
    public void testPositiveDownLeft(){
        var dna = new String[]{
            "ATGCGA", 
            "CAGTCC", 
            "TTACGT", 
            "TACCGA", 
            "CCCGGA", 
            "TCACTG"};
        assertTrue(isMutant(dna));
    }

    @Test
    public void testPositiveDownRight(){
        var dna = new String[]{
            "ATGCGA", 
            "CAGTCC", 
            "TTACGT", 
            "TACAGA", 
            "CCCAGA", 
            "TCACTG"};
        assertTrue(isMutant(dna));
    }

    @Test
    public void testNegative(){
        var dna = new String[]{
            "ATGCGA", 
            "CAGTTC", 
            "TTTCGT", 
            "TACGGA", 
            "CCCAGA", 
            "TCACTG"};
        assertFalse(isMutant(dna));
    }

    @Test
    public void testNull(){
        var dna = (String[]) null;
        assertFalse(isMutant(dna));
    }

    @Test
    public void testEmpty(){
        var dna = new String[]{};
        assertFalse(isMutant(dna));
    }

    @Test
    public void testEmptier(){
        var dna = new String[]{""};
        assertFalse(isMutant(dna));
    }

    @Test
    public void testInvalidChars(){
        var dna = new String[]{
            "ATGCGX", 
            "CAGTTX", 
            "TTTCGX", 
            "YYYYYX", 
            "CCCAGX", 
            "TCACTX"};
        assertFalse(isMutant(dna));
    }

    @Test
    public void testInvalidMatrix(){
        var dna = new String[]{
            "ATGCGX", 
            "CAGT", 
            "TGX", 
            "", 
            null, 
            "TCACTX"};
        assertFalse(isMutant(dna));
    }


    @Test
    public void testPositiveLong(){
        var dna = new String[]{
            "ATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGA", 
            "CAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGC",
            "GTCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGTC", 
            "CAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGC",
            "ATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGA", 
            "CAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGC",
            "GTCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGTC", 
            "ATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGA", 
            "CAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGC",
            "GTCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGTC", 
            "CAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGC",
            "ATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGA", 
            "CAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGC",
            "GTCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGTC",
            "ATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGA", 
            "CAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGC",
            "GTCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGTC", 
            "CAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGC",
            "ATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGA", 
            "CAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGC",
            "GTCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGTC",
            "ATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGA", 
            "CAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGC",
            "GTCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGTC", 
            "CAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGC",
            "ATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGA", 
            "CAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGC",
            "GTCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGTC",
            "CAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCACCCC"
        };
        assertTrue(isMutant(dna));
    }

    //@Test
    public void testStringInterface(){
        var dna = """
                AAAAGX
                CAGTTX
                TTTCGX
                YYYYYX
                CCCAGX
                TCACTX
                """;
        assertTrue(Boolean.valueOf(isMutant(dna)));
    }

    //@Test
    public void testRESTful() {
        given()
          .when()
            .body("{\"dna\": [\"AAAAGX\"]}")
            .contentType("application/json")
            .post("/simian")
          .then()
             .statusCode(200);
    }

    //@Test
    public void testRESTfulNotSimian() {
        given()
          .when()
            .body("{\"dna\": [\"AAAGGX\"]}")
            .contentType("application/json")
            .post("/simian")
          .then()
             .statusCode(403);
    }
}