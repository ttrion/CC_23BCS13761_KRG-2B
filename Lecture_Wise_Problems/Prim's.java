import java.util.*;
public class Prim's {
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        addEdge(adj, 0, 1, 2);
        addEdge(adj, 0, 3, 6);
        addEdge(adj, 1, 2, 3);
        addEdge(adj, 1, 3, 8);
        addEdge(adj, 1, 4, 5);
        addEdge(adj, 2, 4, 7);
        addEdge(adj, 3, 4, 9);
        System.out.println("Minimum Spanning Tree (Prim's Algorithm): " + primMST(V, adj));
    }
    static class Pair {
        int vertex;
        int weight;
        Pair(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
    public static void addEdge(ArrayList<ArrayList<Pair>> adj, int u, int v, int w) {
        adj.get(u).add(new Pair(v, w));
        adj.get(v).add(new Pair(u, w)); 
    }
    public static List<String> primMST(int V, ArrayList<ArrayList<Pair>> adj) {
        boolean[] visited = new boolean[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.weight));
        List<String> mstEdges = new ArrayList<>();
        pq.offer(new Pair(0, 0)); 
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int vertex = current.vertex;
            int weight = current.weight;
            if (visited[vertex]) continue;
            visited[vertex] = true;
            if (weight != 0) { 
                mstEdges.add(vertex + " (weight: " + weight + ")");
            }
            for (Pair neighbor : adj.get(vertex)) {
                if (!visited[neighbor.vertex]) {
                    pq.offer(new Pair(neighbor.vertex, neighbor.weight));
                }
            }
        }
        return mstEdges;
    }
}