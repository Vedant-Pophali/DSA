package DAA;

import java.util.Arrays;

public class BellmanFord {

    private static final int INF = Integer.MAX_VALUE;

    public static void bellmanFord(int[][] graph, int V, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, INF);
        dist[src] = 0;

        // Relax edges V-1 times
        for (int i = 1; i < V; i++) {
            for (int u = 0; u < V; u++) {
                for (int v = 0; v < V; v++) {
                    if (graph[u][v] != 0 && dist[u] != INF && dist[u] + graph[u][v] < dist[v]) {
                        dist[v] = dist[u] + graph[u][v];
                    }
                }
            }
        }

        // Check for negative weight cycles
        for (int u = 0; u < V; u++) {
            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && dist[u] != INF && dist[u] + graph[u][v] < dist[v]) {
                    System.out.println("Graph contains a negative weight cycle!");
                    return;
                }
            }
        }

        // Print final distances
        System.out.println("Shortest distances from source " + src + ":");
        for (int i = 0; i < V; i++) {
            if (dist[i] == INF)
                System.out.println("To vertex " + i + " = Unreachable");
            else
                System.out.println("To vertex " + i + " = " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 6, 0, 7, 0},
                {0, 0, 5, 8, -4},
                {0, -2, 0, 0, 0},
                {0, 0, -3, 0, 9},
                {2, 0, 7, 0, 0}
        };

        int V = 5, src = 0;
        bellmanFord(graph, V, src);
    }
}