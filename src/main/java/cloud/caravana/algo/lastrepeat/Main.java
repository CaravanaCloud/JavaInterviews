package cloud.caravana.algo.lastrepeat;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        var input = "abracadabra";
        var output = lastRepeating(input);
        System.out.println(output);
    }

    
    // para cada caracter
        // marcar a ocorrencia em um set
        // se o caracter ja existe no mapa, atualiza o resultado
    public static String lastRepeating(String input) {
        if (input == null) {
            return "";
        }
        var result = "";
        var repeat = new HashSet<Character>();
        for (int i = 0; i < input.length(); i++) {
            var c = input.charAt(i);
            if (repeat.contains(c)) {
                result = c + "";
            } else {
                repeat.add(c);
            }            
        }
        return result;
    }
    
}
