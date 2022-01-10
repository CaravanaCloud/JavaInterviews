package cloud.caravana.algo.subsequence;

import java.util.*;

class Program {
    // Complexity: cpu - proportional to arrays length // mem - constant
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        if (array == null || sequence == null) {
            return false;
        }
        if (sequence.isEmpty()) {
            return true;
        }
        int a = 0, s = 0;
        // Stop if either array ends
        while (a < array.size() && s < sequence.size()) {
            if (array.get(a).equals(sequence.get(s))) {
              // s progress when match is found
              s++;
            }
            a++;
        }
        // success if all matched
        return s == sequence.size();
    }
}
  