package cloud.caravana.algo.draft;

public class Mutant {
    public static boolean isMutant(String[] dna){
        if (dna == null) return false;
        //para cada linha
        for (int i = 0; i < dna.length; i++) {
            var line = dna[i];
            //para cada coluna
            for (int j = 0; j < line.length(); j++) {
                //verificar se é mutante
                if (isMutant(dna, i, j)){
                    //se for mutante, retornar true
                    System.out.println("Mutante na linha " + i + " coluna " + j);
                    return true;
                }
            }   
        }
        return false;
    }

    private static boolean isMutant(String[] dna, int i, int j) {
        var right = isMatch( //4 posicoes com valor igual
            dna,
            i, j,
            i, j+1,
            i, j+2,
            i, j+3
         );
        if (right) return true;

        var down = isMatch(
            dna,
            i, j,
            i+1, j,
            i+2, j,
            i+3, j
        );
        if (down) return true;

        var downLeft = isMatch(
            dna,
            i, j,
            i+1, j-1,
            i+2, j-2,
            i+3, j-3
        );
        if (downLeft) return true;

        var downRight = isMatch(
            dna,
            i, j,
            i+1, j+1,
            i+2, j+2,
            i+3, j+3
        );
        if (downRight) return true;

        return false;
    }

    private static boolean isMatch(String[] dna, 
    int i1, int j1, 
    int i2, int j2, 
    int i3, int j3, 
    int i4, int j4) {
        var c = valueOf(dna, i1, j1);
        if (c == null) return false;
        var match = c.equals(valueOf(dna, i2, j2))
            &&  c.equals(valueOf(dna, i3, j3))
            &&  c.equals(valueOf(dna, i4, j4));
        return match;
    }

    public static Character valueOf(String[] dna, int i, int j) {
        var outOfBounds = i < 0 || j < 0 
        || i >= dna.length 
        || j >= dna[i].length();
        if(outOfBounds) return null;
        var line =  dna[i];
        return line.charAt(j);
    }
}
