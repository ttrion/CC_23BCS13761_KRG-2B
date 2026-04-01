import java.util.*;

class UnionFind{
    int[] parent;
    int[] rank;

    public UnionFind(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i=0; i<n; i++){
            makeSet(i);
        }
    }

    public void makeSet(int v){
        parent[v] = v;
        rank[v] = 0;
    }

    public int findSet(int v){
        if(parent[v] != v){
            parent[v] = findSet(parent[v]);
        }
        return parent[v];
    }

    public void unionSets(int a, int b){
        a=findSet(a);
        b=findSet(b);
        if(a!=b){
            if(rank[a]<rank[b]){
                int temp=a;
                a=b;
                b=temp;
            }
            parent[b]=a;
            if(rank[a]==rank[b]){
                rank[a]++;
            }
        }
    }
}

class Edge implements Comparable<Edge>{
    int u;
    int v;
    int weight;

    public Edge(int u, int v, int weight){
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other){
        return Integer.compare(this.weight, other.weight);
    }
}

public class KruskalMST{
    public static void main(String[] args){
        int n = 4;
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));

        Collections.sort(edges);
        UnionFind uf = new UnionFind(n);
        List<Edge> mst = new ArrayList<>();

        for(Edge edge : edges){
            if(uf.findSet(edge.u) != uf.findSet(edge.v)){
                uf.unionSets(edge.u, edge.v);
                mst.add(edge);
            }
        }

        System.out.println("Edges in the Minimum Spanning Tree:");
        for(Edge edge : mst){
            System.out.println(edge.u + " -- " + edge.v + " (weight: " + edge.weight + ")");
        }
    }
}