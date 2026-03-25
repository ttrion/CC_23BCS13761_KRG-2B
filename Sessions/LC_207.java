import java.util.*;
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) adj[i] = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for (int[] p : prerequisites) {
            adj[p[1]].add(p[0]);
            indegree[p[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) q.add(i);
        }
        int count = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            count++; 
            for (int v : adj[u]) {
                indegree[v]--;
                if (indegree[v] == 0) q.add(v);
            }
        }
        
        return count == numCourses;
    }
}