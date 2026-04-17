class FenwickTree {
    private int[] tree;
    private int n;
    public FenwickTree(int n) {
        this.n = n;
        tree = new int[n + 1]; 
    }
    public FenwickTree(int[] arr) {
        this.n = arr.length;
        tree = new int[n + 1];
        for (int i = 0; i < n; i++) {
            update(i + 1, arr[i]);
        }
    }
    public void update(int i, int delta) {
        while (i <= n) {
            tree[i] += delta;
            i += i & -i; 
        }
    }
    public int query(int i) {
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= i & -i; 
        }
        return sum;
    }
    public int rangeQuery(int l, int r) {
        return query(r) - query(l - 1);
    }
}