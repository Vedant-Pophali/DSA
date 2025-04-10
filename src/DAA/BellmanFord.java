package DAA; // Package declaration
import java.util.Arrays; // Importing utility class for array operations
public class BellmanFord {
    private static final int INF = Integer.MAX_VALUE; // Representing "infinity" for unreachable nodes
    // Function to implement the Bellman-Ford algorithm
    public static void bellmanFord(int[][] graph, int V, int src) {
        int[] dist = new int[V]; // Array to store shortest distances from the source to all vertices
        int[] parent = new int[V];//Stores the path
        Arrays.fill(parent, -1);//Initialize all to -1
        Arrays.fill(dist, INF);  // Initialize all distances as infinity
        dist[src] = 0;           // Distance to the source itself is 0
        // Step 1: Relax all edges V-1 times
        for (int i = 1; i < V; i++) { // Repeat V-1 times
            for (int u = 0; u < V; u++) {       // Loop over all vertices as source
                for (int v = 0; v < V; v++) {   // Loop over all vertices as destination
                    // If there is an edge from u to v and u is reachable
                    if (graph[u][v] != 0 && dist[u] != INF && dist[u] + graph[u][v] < dist[v]) {
                        dist[v] = dist[u] + graph[u][v]; // Update the distance to vertex v
                        parent[v] = u;
                    }
                }
            }
        }
        // Step 2: Check for negative-weight cycles
        for (int u = 0; u < V; u++) {
            for (int v = 0; v < V; v++) {
                // If a shorter path is still found, then there is a negative cycle
                if (graph[u][v] != 0 && dist[u] != INF && dist[u] + graph[u][v] < dist[v]) {
                    System.out.println("Graph contains a negative weight cycle!");
                    return; // Exit if negative cycle is found
                }
            }
        }

        // Step 3: Print the shortest distances from source
        System.out.println("Shortest distances from source " + src + ":");
        for (int i = 0; i < V; i++) {
            if (dist[i] == INF)
                System.out.println("To vertex " + i + " = Unreachable");
            else {
                System.out.print("To vertex " + i + " = " + dist[i] + " | Path: ");
                printParent(i, parent);
                System.out.println();
            }
        }
    }
    public static void printParent(int v, int[] parent) {
        if(v==-1) return;
        printParent(parent[v], parent);
        System.out.print(v+" ");
    }
    public static void main(String[] args) {
        // Define a sample graph as an adjacency matrix
        int[][] graph = {
                {0, 6, 0, 7, 0},   // Edges from vertex 0
                {0, 0, 5, 8, -4},  // Edges from vertex 1
                {0, -2, 0, 0, 0},  // Edges from vertex 2
                {0, 0, -3, 0, 9},  // Edges from vertex 3
                {2, 0, 7, 0, 0}    // Edges from vertex 4
        };
        int V = graph.length, src = 0; // Number of vertices and source vertex
        bellmanFord(graph, V, src); // Call Bellman-Ford algorithm
    }
}