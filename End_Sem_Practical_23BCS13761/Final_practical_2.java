import java.util.*;

public class FloydWarshall {
    static final int INF = 1000000000;

    public static void floydWarshall(int[][] dist) {
        int n = dist.length;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] < INF && dist[k][j] < INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String val = sc.next();
                if (val.equals("INF")) graph[i][j] = INF;
                else graph[i][j] = Integer.parseInt(val);
            }
        }

        floydWarshall(graph);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == INF) System.out.print("INF ");
                else System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
