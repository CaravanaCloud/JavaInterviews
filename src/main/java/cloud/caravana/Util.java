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

    public static int intFromLine(String input, int lineNumber) {
        var text = linesToArray(input)[lineNumber];
        var result = Integer.parseInt(text.trim());
        return result;
    }

    public static int[] intArrayStartingLine(String input, int lineNumber) {
        var lines = Arrays.asList(linesToArray(input));
        var resultList = lines.subList(lineNumber, lines.size());
        var result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            var text = resultList.get(i).trim();
            result[i] = Integer.parseInt(text);
        }
        return result;
    }
 
    public static final List<List<Integer>> parseInput(String file) {
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
}
