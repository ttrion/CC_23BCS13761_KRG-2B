import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] names = new String[n];
        for (int i = 0; i < n; i++) names[i] = sc.next();

        List<Integer>[] adj = new ArrayList[26];
        for (int i = 0; i < 26; i++) adj[i] = new ArrayList<>();
        int[] indegree = new int[26];

        for (int i = 0; i < n - 1; i++) {
            String s = names[i], t = names[i + 1];
            int len = Math.min(s.length(), t.length());
            boolean found = false;

            for (int j = 0; j < len; j++) {
                if (s.charAt(j) != t.charAt(j)) {
                    adj[s.charAt(j) - 'a'].add(t.charAt(j) - 'a');
                    found = true;
                    break;
                }
            }

            if (!found && s.length() > t.length()) {
                System.out.println("Impossible");
                return;
            }
        }

        for (int i = 0; i < 26; i++) {
            for (int v : adj[i]) indegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        StringBuilder res = new StringBuilder();
        while (!q.isEmpty()) {
            int u = q.poll();
            res.append((char)(u + 'a'));
            for (int v : adj[u]) {
                indegree[v]--;
                if (indegree[v] == 0) q.add(v);
            }
        }

        if (res.length() != 26) System.out.println("Impossible");
        else System.out.println(res.toString());
    }
}