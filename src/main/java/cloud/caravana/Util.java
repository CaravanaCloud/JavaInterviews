package cloud.caravana;

import java.io.BufferedReader;
import java.io.*;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Util {
    public static final String[] linesToArray(String lines) {
        return lines.split("\n");
    }

    public static final String arrayToLines(int[] array) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            sb.append("\n");
        }
        return sb.toString();
    }

    public static final List<List<Integer>> parseCIGInput(String file) {
        try {
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            // The class loader that loaded the class
            InputStream in = cl.getResourceAsStream(file);

            // the stream holding the file content
            if (in == null) {
                throw new IllegalArgumentException("file not found! " + file);
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));

            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<List<Integer>> gb = new ArrayList<>();

            IntStream.range(0, n).forEach(i -> {
                try {
                    gb.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                    .map(Integer::parseInt)
                                    .collect(toList())
                    );
                } catch (IOException e) {
                    e.printStackTrace();
                }

            });
            return gb;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static int[] commasToInts(String xs) {
        return Arrays.stream(xs.split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
    }


    public static Integer[] intsToIntegers(int[] xs) {
        return IntStream.of(xs).boxed().toArray(Integer[]::new);
    }

    public static Integer[] commasToIntegers(String xs) {
        return intsToIntegers(commasToInts(xs));
    }

    public static final int[] integersToInts(Integer[] xs) {
        return Arrays.stream(xs)
                .mapToInt(Integer::intValue)
                .toArray();
    }

}
