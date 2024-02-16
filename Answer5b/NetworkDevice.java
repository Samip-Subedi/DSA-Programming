package Answer5b;

import java.util.*;

public class NetworkDevice {
    public static List<Integer> findImpactedDevices(int[][] edges, int targetDevice) {
        Map<Integer, List<Integer>> graph = buildGraph(edges);
        Set<Integer> visited = new HashSet<>();
        List<Integer> impactedDevices = new ArrayList<>();

        dfs(graph, targetDevice, visited, impactedDevices);
        impactedDevices.remove((Integer) targetDevice);

        return impactedDevices;
    }

    private static void dfs(Map<Integer, List<Integer>> graph, int device, Set<Integer> visited, List<Integer> impactedDevices) {
        visited.add(device);
        impactedDevices.add(device);
        List<Integer> connectedDevices = graph.getOrDefault(device, new ArrayList<>());

        for (int connectedDevice : connectedDevices) {
            if (!visited.contains(connectedDevice)) {
                dfs(graph, connectedDevice, visited, impactedDevices);
            }
        }
    }

    private static Map<Integer, List<Integer>> buildGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(u).add(v);
        }

        return graph;
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1},{0,2},{1,3},{1,6},{2,4},{4,6},{4,5},{5,7}};
        int targetDevice = 4;
        List<Integer> impactedDevices = findImpactedDevices(edges, targetDevice);
        System.out.println("Impacted Device List: " + impactedDevices);
    }
}