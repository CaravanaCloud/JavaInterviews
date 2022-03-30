package cloud.caravana.algo.cig;

import java.util.*;

public class CIGTree {
    public static List<Integer> componentsInGraph(List<List<Integer>> edges) {
        var parents = new HashMap<Integer /*Node*/, Integer /*Component*/>();
        var sizes = new HashMap<Integer /*Component*/, Integer/*Size*/>();

        for (List<Integer> edge: edges){
            var a = edge.get(0);
            var b = edge.get(1);
            union(parents, sizes, a, b);
        }

        Integer min = Integer.MAX_VALUE;
        Integer max = Integer.MIN_VALUE;

        for(Map.Entry<Integer, Integer> entry:sizes.entrySet()) {
            var size = entry.getValue();
            if (size > max) max = size;
            if (size < min && size > 1) min = size;
        }
        return List.of(min,max);
    }

    private static void union(HashMap<Integer, Integer> parents,
                              HashMap<Integer, Integer> sizes,
                              Integer a, Integer b) {
        var rootA = root(parents, a);
        var rootB = root(parents, b);
        if (rootA.equals(rootB)) return;
        var sizeA = sizes.getOrDefault(rootA, 1);
        var sizeB = sizes.getOrDefault(rootB, 1);
        var newSize = sizeA + sizeB;
        if (sizeA < sizeB){
            parents.put(rootA, rootB);
            sizes.put(rootB, newSize);
            sizes.remove(rootA);
        }else {
            parents.put(rootB, rootA);
            sizes.put(rootA, newSize);
            sizes.remove(rootB);
        }
    }

    private static Integer root(HashMap<Integer, Integer> parents, Integer a) {
        var parent = parents.getOrDefault(a, a);
        while (! parent.equals(a)){
            a = parent;
            parent = parents.getOrDefault(a, a);
        }
        return parent;
    }


}
