package cloud.caravana.algo.reverse;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class ReverseInplace {

    public static String reverse(String value) {
        if (value == null) return null;
        var arr = value.toCharArray();
        reverseArray(arr);
        return String.valueOf(arr);
    }

    private static void reverseArray(char[] arr) {
        for (int i = 0; i < arr.length/2; i++) {
            var other = arr.length - 1 - i;
            // Swap using XOR
            arr[i] ^= arr[other];
            arr[other] ^= arr[i];
            arr[i] ^= arr[other];
            // Alternative using a temporary variable
            // var temp = arr[i];
            // arr[i] = arr[other];
            // arr[other] = temp;
        }
    }
}
