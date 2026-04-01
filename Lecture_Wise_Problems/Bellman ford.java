import java.util.*;
class BellmanFord {
    static class Edge {
        int source, destination, weight;
        Edge(int s, int d, int w) {
            source = s; destination = d; weight = w;
        }
    }

    int vertices;
    Edge[] edges;

    BellmanFord(int v, int e) {
        vertices = v;
        edges = new Edge[e];
    }

    void bellmanFord(int source) {
        int[] dist = new int[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        // Relax edges |V| - 1 times
        for (int i = 1; i < vertices; i++) {
            for (Edge e : edges) {
                if (dist[e.source] != Integer.MAX_VALUE && 
                    dist[e.source] + e.weight < dist[e.destination]) {
                    dist[e.destination] = dist[e.source] + e.weight;
                }
            }
        }

        // Check for negative weight cycles
        for (Edge e : edges) {
            if (dist[e.source] != Integer.MAX_VALUE && 
                dist[e.source] + e.weight < dist[e.destination]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }

        // Print distances
        for (int i = 0; i < vertices; i++) {
            System.out.println("Distance from " + source + " to " + i + " = " + dist[i]);
        }
    }

    public static void main(String[] args) {
    int V = 5, E = 8;
    BellmanFord graph = new BellmanFord(V, E);

    // Add edges: source, destination, weight
    graph.edges[0] = new Edge(0, 1, -1);
    graph.edges[1] = new Edge(0, 2, 4);
    // ... add other edges
    graph.bellmanFord(0);
    }   
}   