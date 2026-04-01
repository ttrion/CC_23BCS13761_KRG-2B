import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] flight : flights) {
            adj.computeIfAbsent(flight[0], x -> new ArrayList<>())
               .add(new int[]{flight[1], flight[2]});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0}); 

        int stops = 0;

        while (!queue.isEmpty() && stops <= k) {
            int size = queue.size();
            int[] temp = Arrays.copyOf(dist, n);

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int node = curr[0];
                int cost = curr[1];

                if (!adj.containsKey(node)) continue;

                for (int[] nei : adj.get(node)) {
                    int nextNode = nei[0];
                    int price = nei[1];

                    int newCost = cost + price;

                    if (newCost < temp[nextNode]) {
                        temp[nextNode] = newCost;
                        queue.offer(new int[]{nextNode, newCost});
                    }
                }
            }

            dist = temp; 
            stops++;
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}