package cloud.caravana.algo.mutant;

import cloud.caravana.Util;

public class Mutant {
    
    static Character charAt(String[] dna, int i, int j){
        var outOfBounds = i < 0 || j < 0
            || i >= dna.length
            || j >= dna[i].length();
        if (outOfBounds)
            return null;
        var c = dna[i].charAt(j);
        var valid = c == 'A' || c == 'T' || c == 'C' || c == 'G';    
        if (! valid)
            return null;
        return c;
    }

    static boolean isMatch(String[] dna,
        int r0, int c0,
        int r1, int c1,
        int r2, int c2,
        int r3, int c3) {
        var c = charAt(dna, r0, c0);
        var match = c != null
            && c == charAt(dna, r1, c1)
            && c == charAt(dna, r2, c2)
            && c == charAt(dna, r3, c3);
        return match;
    }

    static boolean isMutant (String[] dna, int i, int j){
        var right = isMatch(dna, 
            i, j, 
            i, j+1, 
            i, j+2, 
            i, j+3); 
        if (right)
            return true;
    
        var down = isMatch(dna, 
            i, j, 
            i+1, j, 
            i+2, j, 
            i+3, j);
        if (down)
            return true;

        var downLeft =
            isMatch(dna, 
                i, j, 
                i+1, j-1, 
                i+2, j-2, 
                i+3, j-3);
        if (downLeft)
            return true;
    
        var downRight = isMatch(dna, 
            i, j, 
            i+1, j+1,
            i+2, j+2,
            i+3, j+3);
        if (downRight)
            return true;
        
        return false;
    }

    public static boolean isMutant(String[] dna){
        if (dna == null) return false;
        for(var i=0; i < dna.length; i++){
            var line = dna[i];
            if (line != null) 
                for (var j=0; j < line.length(); j++)
                    if (isMutant(dna, i, j)){
                        System.out.println("Simian found at " + i + " " + j);
                        return true;
                    }
                }
        return false;
    }

    public static String isMutant (String dnaStr){
        String[] dna = Util.linesToArray(dnaStr);
        return ""+isMutant(dna);
    }
}
