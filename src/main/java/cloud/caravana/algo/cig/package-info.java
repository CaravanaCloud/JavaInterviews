package cloud.caravana.algo.cig;

/**
 * Components in a Graph
 * source: https://www.hackerrank.com/challenges/components-in-graph/problem
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