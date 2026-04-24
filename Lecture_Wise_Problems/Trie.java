class Trie {
    static class Node {
        Node[] c = new Node[26];
        boolean e;
    }

    private final Node r = new Node();

    public void insert(String w) {
        Node n = r;
        for (int i = 0; i < w.length(); i++) {
            int x = w.charAt(i) - 'a';
            if (n.c[x] == null) n.c[x] = new Node();
            n = n.c[x];
        }
        n.e = true;
    }

    public boolean search(String w) {
        Node n = r;
        for (int i = 0; i < w.length(); i++) {
            int x = w.charAt(i) - 'a';
            if (n.c[x] == null) return false;
            n = n.c[x];
        }
        return n.e;
    }

    public boolean startsWith(String p) {
        Node n = r;
        for (int i = 0; i < p.length(); i++) {
            int x = p.charAt(i) - 'a';
            if (n.c[x] == null) return false;
            n = n.c[x];
        }
        return true;
    }
}