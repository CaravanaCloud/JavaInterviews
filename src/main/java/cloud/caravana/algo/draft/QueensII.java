package cloud.caravana.algo.draft;

import static java.util.stream.Collectors.toSet;

import java.util.List;
import static java.util.List.of;
import java.util.Set;

public class QueensII {
    public static int queensAttack(int n, int k,
            int r_q, int c_q,
            List<List<Integer>> obstacles) {
        // "Indexar" os obstáculos
        var blocks = (Set<List<Integer>/* Pair */>) obstacles.stream()
                .map(sq -> List.of(sq.get(0), sq.get(1)))
                .collect(toSet());
        // partir da rainha e contar em cada direcao
        var l = left(r_q, c_q, blocks);
        var r = right(n, r_q, c_q, blocks);
        var u = up(r_q, c_q, blocks);
        var d = down(n, r_q, c_q, blocks);
        var dl = downLeft(n, r_q, c_q, blocks);
        var dr = downRight(n, r_q, c_q, blocks);
        var ul = upLeft(n, r_q, c_q, blocks);
        var ur = upRight(n, r_q, c_q, blocks);
        // somar as casas alcancaveis
        return l + r + u + d + dl + dr + ul + ur;
    }

    private static int left(int r_q, int c_q, Set<List<Integer>> blocks) {
        var count = 0;
        var progress = true;
        while (progress) {
            c_q--;
            var inside = c_q > 0;
            var unblocked = !blocks.contains(of(r_q, c_q));
            progress = inside && unblocked;
            if (progress)
                count++;
        }
        return count;
    }

    private static int right(int n, int r_q, int c_q, Set<List<Integer>> blocks) {
        var count = 0;
        var progress = true;
        while (progress) {
            c_q++;
            var inside = c_q <= n;
            var unblocked = !blocks.contains(of(r_q, c_q));
            progress = inside && unblocked;
            if (progress)
                count++;
        }
        return count;
    }

    private static int down(int n, int r_q, int c_q, Set<List<Integer>> blocks) {
        var count = 0;
        var progress = true;
        while (progress) {
            r_q++;
            var inside = r_q <= n;
            var unblocked = !blocks.contains(of(r_q, c_q));
            progress = inside && unblocked;
            if (progress)
                count++;
        }
        return count;
    }

    private static int up(int r_q, int c_q, Set<List<Integer>> blocks) {
        var count = 0;
        var progress = true;
        while (progress) {
            r_q--;
            var inside = r_q > 0;
            var unblocked = !blocks.contains(of(r_q, c_q));
            progress = inside && unblocked;
            if (progress)
                count++;
        }
        return count;
    }

    private static int upLeft(int n, int r_q, int c_q, Set<List<Integer>> blocks) {
        var count = 0;
        var progress = true;
        while (progress) {
            r_q--;
            c_q--;
            var inside = c_q > 0 && r_q > 0;
            var unblocked = !blocks.contains(of(r_q, c_q));
            progress = inside && unblocked;
            if (progress)
                count++;
        }
        return count;
    }

    private static int upRight(int n, int r_q, int c_q, Set<List<Integer>> blocks) {
        var count = 0;
        var progress = true;
        while (progress) {
            r_q--;
            c_q++;
            var inside = r_q > 0 && c_q <= n;
            var unblocked = !blocks.contains(of(r_q, c_q));
            progress = inside && unblocked;
            if (progress)
                count++;
        }
        return count;
    }

    private static int downLeft(int n, int r_q, int c_q, Set<List<Integer>> blocks) {
        var count = 0;
        var progress = true;
        while (progress) {
            r_q++;
            c_q--;
            var inside = c_q > 0 && r_q <= n;
            var unblocked = !blocks.contains(of(r_q, c_q));
            progress = inside && unblocked;
            if (progress)
                count++;
        }
        return count;
    }

    private static int downRight(int n, int r_q, int c_q, Set<List<Integer>> blocks) {
        var count = 0;
        var progress = true;
        while (progress) {
            r_q++;
            c_q++;
            var inside = c_q <= n && r_q <= n;
            var unblocked = !blocks.contains(of(r_q, c_q));
            progress = inside && unblocked;
            if (progress)
                count++;
        }
        return count;
    }
}
