package cloud.caravana.algo.pairsum;

import static cloud.caravana.Util.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

public class PairSum {
    // cpu/tempo = O(n log n) + O(n) = O(n log n) // mem/espaco = O(1)
    public static int[] tunnelTwoNumberSum(int[] array, int targetSum) {
        if (array == null) return null;
        Arrays.sort(array); // TimSort O(n log n)
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int sum = array[left] + array[right];
            if (sum == targetSum) {
                return new int[]{array[left], array[right]};
            } else if (sum < targetSum) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }

    // tempo/cpu = O(n) espaco/memoria = O(n)
    public static int[] memoTwoNumberSum(int[] array, int targetSum) {
        if (array == null) return null;
        var memo = new HashSet<Integer>();
        for(int i = 0; i < array.length; i++) {
            var complement = targetSum - array[i];
            if(memo.contains(complement)) {
                return new int[]{complement, array[i]};
            }
            memo.add(array[i]);
        }
        return null;
    }

    // O(n²) tempo/cpu - O(1) espaco/memoria
    public static int[] iterTwoNumberSum(int[] xs, int targetSum) {
        if (xs == null) return null;
        for (int i = 0; i < xs.length; i++) {
            for (int j = i + 1; j < xs.length; j++) {
                if (xs[i] + xs[j] == targetSum) {
                    var result = new int[2];
                    result[0] = xs[i];
                    result[1] = xs[j];
                    return result;
                }
            }
        }
        return null;
    }


    public static Integer[] iterPairSum(Integer[] xs, Integer target) {
        var _xs = integersToInts(xs);
        var result = iterTwoNumberSum(_xs, target);
        return intsToIntegers(result);
    }

    public static Integer[] memoPairSum(Integer[] xs, Integer target) {
        var _xs = integersToInts(xs);
        var result = memoTwoNumberSum(_xs, target);
        return intsToIntegers(result);
    }

    public static Integer[] tunnelPairSum(Integer[] xs, Integer target) {
        var _xs = integersToInts(xs);
        var result = tunnelTwoNumberSum(_xs, target);
        return intsToIntegers(result);
    }

    static final DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
    public static void main(String[] args) {
        var xs = new Random()
        .ints(50_000_000, 0, 100000)
            .boxed()
            .toArray(Integer[]::new);
        var target = 1337;
        timestamp("Initial: ");        
        var result = iterPairSum(xs, target);
        System.out.println(Arrays.toString(result));
        timestamp("Iterative: ");
        result = memoPairSum(xs, target);
        System.out.println(Arrays.toString(result));
        timestamp("Memoized: ");
        result = tunnelPairSum(xs, target);
        System.out.println(Arrays.toString(result));
        timestamp("Tunnel:");
    }

    private static void timestamp(String msg) {
        System.out.println(msg + LocalDateTime.now().format(df));
    }
}
