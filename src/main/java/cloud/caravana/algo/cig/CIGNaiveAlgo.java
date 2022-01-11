package cloud.caravana.algo.cig;

import java.io.*;
import java.util.*;

import cloud.caravana.Util;

/**
 * Components in a Graph
 * https://www.hackerrank.com/challenges/components-in-graph/problem
 * 
 * There are 2*N nodes in an undirected graph, and a number of edges connecting some nodes. 
 * In each edge, the first value will be between 1 and N, inclusive. 
 * The second node will be between N+1 and 2*N, inclusive. 
 * Given a list of edges, determine the size of the smallest and largest connected components that have  or more nodes. 
 * A node can have any number of connections. 
 * The highest node value will always be connected to at least 1 other node.

 * Note: Single nodes should not be considered in the answer.
 * 
 * Sample Input
 *  bg = [[1, 6],[2, 7], [3, 8], [4,9], [2, 6]]
 * 
 * Sample Output
 *  [2, 4]
 */
class CIGNaiveAlgo {
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
        var gb = Util.parseInput(file);
        List<Integer> result = CIGPerfAlgo.componentsInGraph(gb);
        System.out.println(result);
    }

}