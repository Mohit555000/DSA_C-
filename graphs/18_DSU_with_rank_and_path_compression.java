// watch this 1 https://youtu.be/AsAdKHkITBQ?si=Bby8SJoBRiBt3Iwn
// watch this 2 https://youtu.be/iH3XVIVzl7M?si=aCXdI_UGkNvWV453
// watch this 3 https://youtu.be/Kptz-NVA2RE?si=6aDWzihIbfd5A8iM

class DSU {

    int[] parent;
    int[] rank;

    // Constructor
    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];

        // Initially every node is its own parent
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    // Find with Path Compression
    public int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    // Union by Rank
    public void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);

        if (xParent == yParent) {
            return;
        }

        if (rank[xParent] > rank[yParent]) {
            parent[yParent] = xParent;
        } else if (rank[xParent] < rank[yParent]) {
            parent[xParent] = yParent;
        } else {
            parent[xParent] = yParent;
            rank[yParent]++;
        }
    }
}
