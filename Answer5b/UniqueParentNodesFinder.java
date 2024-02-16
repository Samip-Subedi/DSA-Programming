package Answer5b;

import java.util.*;

public class UniqueParentNodesFinder {

    public static List<Integer> findUniqueParentNodes(int[][] edges, int target) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();

        // Construct the graph and calculate in-degrees
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(to);
            inDegree.put(to, inDegree.getOrDefault(to, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        exploreGraph(graph, inDegree, target, target, result);

        return result;
    }

    // Explore the graph using Depth-first search to find nodes with only the target as parent
    private static void exploreGraph(Map<Integer, List<Integer>> graph, Map<Integer, Integer> inDegree, int node,
            int target, List<Integer> result) {

        // If the node has only one incoming edge and it's not the target node itself, add it to the result
        if (inDegree.getOrDefault(node, 0) == 1 && node != target) {
            result.add(node);
        }

        // Traverse children recursively
        if (graph.containsKey(node)) {
            for (int child : graph.get(node)) {
                exploreGraph(graph, inDegree, child, target, result);
            }
        }
    }

    public static void main(String[] args) {
        // Sample input
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 1, 6 }, { 2, 4 }, { 4, 6 }, { 4, 5 }, { 5, 7 } };
        int target = 4;

        // Find nodes whose only parent is the target
        List<Integer> uniqueParentNodes = findUniqueParentNodes(edges, target);

        // Print the result
        System.out.print("Nodes whose only parent is " + target + ": {");
        for (int i = 0; i < uniqueParentNodes.size(); i++) {
            System.out.print(uniqueParentNodes.get(i));
            if (i < uniqueParentNodes.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }
}
