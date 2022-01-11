package cloud.caravana.algo.queens2;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Queens2 {
    private static String encode(int a, int b) {
        // Arrays.hasCode(new int[]{a, b})
        // a * 31 + b
        // (a+","+b).hashCode();
        // int[]{a, b}.hashCode();
        return ""+a+","+b;
    }

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        var blocks = obstacles.stream()
                .map(sq -> encode(sq.get(0), sq.get(1)))
                .collect(Collectors.toSet());

        var l = countLeft(r_q, c_q, blocks);
        var r = countRight(n, r_q, c_q, blocks);
        var u = countUp(r_q, c_q, blocks);
        var d = countDown(n, r_q, c_q, blocks);
        var ul = countUpLeft(r_q, c_q, blocks);
        var ur = countUpRight(n, r_q, c_q, blocks);
        var dl = countDownLeft(n, r_q, c_q, blocks);
        var dr = countDownRight(n, r_q, c_q, blocks);
        return l + r + u + d + ul + ur + dl + dr;
    }

    private static int countDownRight(int n, int r_q, int c_q, Set<String> blocks) {
        var count = 0;
        var progress = true;
        while (progress) {
            r_q++;
            c_q++;
            var inside = r_q <= n && c_q <= n;
            var unblocked = !blocks.contains(encode(r_q, c_q));
            progress = inside && unblocked;
            if (progress)
                count++;
        }
        return count;
    }

    private static int countDownLeft(int n, int r_q, int c_q, Set<String> blocks) {
        var count = 0;
        var progress = true;
        while (progress) {
            r_q++;
            c_q--;
            var inside = r_q <= n && c_q > 0;
            var unblocked = !blocks.contains(encode(r_q, c_q));
            progress = inside && unblocked;
            if (progress)
                count++;
        }
        return count;
    }

    private static int countUpRight(int n, int r_q, int c_q, Set<String> blocks) {
        var count = 0;
        var progress = true;
        while (progress) {
            r_q--;
            c_q++;
            var inside = r_q > 0 && c_q <= n;
            var unblocked = !blocks.contains(encode(r_q, c_q));
            progress = inside && unblocked;
            if (progress)
                count++;
        }
        return count;
    }

    private static int countUpLeft(int r_q, int c_q, Set<String> blocks) {
        var count = 0;
        var progress = true;
        while (progress) {
            r_q--;
            c_q--;
            var inside = r_q > 0 && c_q > 0;
            var unblocked = !blocks.contains(encode(r_q, c_q));
            progress = inside && unblocked;
            if (progress)
                count++;
        }
        return count;
    }

    private static int countDown(int n, int r_q, int c_q, Set<String> blocks) {
        var count = 0;
        var progress = true;
        while (progress) {
            r_q++;
            var inside = r_q <= n;
            var unblocked = !blocks.contains(encode(r_q, c_q));
            progress = inside && unblocked;
            if (progress)
                count++;
        }
        return count;
    }

    private static int countUp(int r_q, int c_q, Set<String> blocks) {
        var count = 0;
        var progress = true;
        while (progress) {
            r_q--;
            var inside = r_q > 0;
            var unblocked = !blocks.contains(encode(r_q, c_q));
            progress = inside && unblocked;
            if (progress)
                count++;
        }
        return count;
    }

    private static int countRight(int n, int r_q, int c_q, Set<String> blocks) {
        var count = 0;
        var progress = true;
        while (progress) {
            c_q++;
            var inside = c_q <= n;
            var unblocked = !blocks.contains(encode(r_q, c_q));
            progress = inside && unblocked;
            if (progress)
                count++;
        }
        return count;
    }

    private static int countLeft(int r_q, int c_q, Set<String> blocks) {
        var count = 0;
        var progress = true;
        while (progress) {
            c_q--;
            var inside = c_q > 0;
            var unblocked = !blocks.contains(encode(r_q, c_q));
            progress = inside && unblocked;
            if (progress)
                count++;
        }
        return count;
    }

}
