import java.util.Arrays;

public class UnionFind {
    private int[] parent;
    private int[] size;

    public UnionFind(int n){
        parent = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int i){
        if(parent[i] != i){
            parent[i] = find(parent[i]); 
        }
        return parent[i];
    }

    public void union(int i, int j){
        int irep = find(i);
        int jrep = find(j);
        if(irep == jrep) return;
        if(size[irep] < size[jrep]){
            parent[irep] = jrep;
            size[jrep] += size[irep];
        } else {
            parent[jrep] = irep;
            size[irep] += size[jrep];
        }
    }

    public static void main(String[] args){
        int size = 5;
        UnionFind uf = new UnionFind(size);
        uf.union(1, 2);
        uf.union(3, 4);
        uf.union(1, 4);
        boolean sameSet = uf.find(2) == uf.find(3);
        System.out.println("2 and 3 are in the same set: " + sameSet);
    }
}