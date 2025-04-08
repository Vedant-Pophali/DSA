package DAA;

import java.util.*;

public class FordFulkerson {

    private static boolean bfs(int[][] resGraph, int src, int sink, int[] parent) {
        int n = resGraph.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        q.add(src);
        visited[src] = true;
        parent[src] = -1;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v = 0; v < n; v++) {
                if (!visited[v] && resGraph[u][v] > 0) {
                    parent[v] = u;
                    if (v == sink) return true;
                    q.add(v);
                    visited[v] = true;
                }
            }
        }
        return false;
    }

    public static int maxFlow(int[][] graph, int src, int sink) {
        int n = graph.length;
        int[][] res = new int[n][n];

        for (int i = 0; i < n; i++) {
            System.arraycopy(graph[i], 0, res[i], 0, n);
        }

        int[] parent = new int[n];
        int flow = 0;

        while (bfs(res, src, sink, parent)) {
            int pathFlow = Integer.MAX_VALUE;

            for (int v = sink; v != src; v = parent[v]) {
                int u = parent[v];
                pathFlow = Math.min(pathFlow, res[u][v]);
            }

            for (int v = sink; v != src; v = parent[v]) {
                int u = parent[v];
                res[u][v] -= pathFlow;
                res[v][u] += pathFlow;
            }

            flow += pathFlow;
        }

        return flow;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 16, 13, 0, 0, 0},
                {0, 0, 10, 12, 0, 0},
                {0, 4, 0, 0, 14, 0},
                {0, 0, 9, 0, 0, 20},
                {0, 0, 0, 7, 0, 4},
                {0, 0, 0, 0, 0, 0}
        };

        int src = 0, sink = 5;
        System.out.println("Maximum flow from source to sink: " + maxFlow(graph, src, sink));
    }
}