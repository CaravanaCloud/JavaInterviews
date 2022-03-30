package cloud.caravana.algo.cig;

import java.io.*;
import java.util.*;

import cloud.caravana.Util;

class CIGMap {
    /* Notes
     * - undirected graph
     * - there is at least one connected component (size 2)
     */

    // mark connections:
    //      edge(a,b) => component(a) == component(b)
    // for each component
    // get size of component
    // compare with min and max
    public static List<Integer> componentsInGraph(List<List<Integer>> edges) {
        var components = new HashMap<Integer /*Node*/, Integer /*Component*/>();
        for (List<Integer> edge: edges){
            var a = edge.get(0);
            var b = edge.get(1);
            edge(components, a, b);
        }

        var sizes = new HashMap<Integer /*Component*/, Integer/*Size*/>();
        for(Map.Entry<Integer, Integer> entry:components.entrySet()) {
            var component = entry.getValue();
            var size = sizes.getOrDefault(component, 0);
            size += 1;
            sizes.put(component, size);
        }

        Integer min = null;
        Integer max = null;
        for(Map.Entry<Integer, Integer> entry:sizes.entrySet()) {
            var size = entry.getValue();
            if (max == null || size > max) max = size;
            if (min == null || size < min) min = size;
        }
        return List.of(min,max);
    }

    private static void edge(HashMap<Integer, Integer> components, Integer a, Integer b) {
        if (a.equals(b)) return;
        var compA = components.getOrDefault(a, a);
        var compB = components.getOrDefault(b, b);
        for(Map.Entry<Integer, Integer> entry:components.entrySet()) {
            if (entry.getValue().equals(compB))
                entry.setValue(compA);
        }
        components.put(b,compA);
        components.put(a,compA);
    }

    public static void main(String[] args) throws IOException {
        String file = "input19.txt";
        var gb = Util.parseCIGInput(file);
        List<Integer> result = CIGTree.componentsInGraph(gb);
        System.out.println(result);
    }

}