import java.util.*;

public class Main {

    static class Edge {
        int to;
        long weight;

        Edge(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Pair implements Comparable<Pair> {
        long dist;
        int node;

        Pair(long dist, int node) {
            this.dist = dist;
            this.node = node;
        }

        public int compareTo(Pair other) {
            return Long.compare(this.dist, other.dist);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Edge>[] adj = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {

            int a = sc.nextInt();
            int b = sc.nextInt();
            long w = sc.nextLong();

            adj[a].add(new Edge(b, w));
            adj[b].add(new Edge(a, w));
        }

        long INF = Long.MAX_VALUE;
        long[] dist = new long[n + 1];
        int[] parent = new int[n + 1];

        Arrays.fill(dist, INF);
        Arrays.fill(parent, -1);

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        dist[1] = 0;
        pq.add(new Pair(0, 1));

        while (!pq.isEmpty()) {

            Pair current = pq.poll();
            long d = current.dist;
            int u = current.node;

            if (d > dist[u])
                continue;

            for (Edge e : adj[u]) {

                int v = e.to;
                long w = e.weight;

                if (dist[u] + w < dist[v]) {

                    dist[v] = dist[u] + w;
                    parent[v] = u;

                    pq.add(new Pair(dist[v], v));
                }
            }
        }

        if (dist[n] == INF) {
            System.out.println(-1);
            return;
        }

        List<Integer> path = new ArrayList<>();

        for (int v = n; v != -1; v = parent[v])
            path.add(v);

        Collections.reverse(path);

        for (int v : path)
            System.out.print(v + " ");
    }
}