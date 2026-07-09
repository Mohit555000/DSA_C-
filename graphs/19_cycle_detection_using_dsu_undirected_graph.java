//https://www.youtube.com/watch?v=0X0lEtTkk-8&list=PLpIkg8OmuX-LZB9jYzbbZchk277H5CbdY&index=20
//https://www.geeksforgeeks.org/problems/detect-cycle-using-dsu/1

class Solution {
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
    public boolean detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        DSU dsu=new DSU(V);
        for(int u=0;u<V;u++){
            for(int v:adj.get(u)){
                // process each edge only once
                if(u<v){
                    int parent_u=dsu.find(u);
                    int parent_v=dsu.find(v);
                    if(parent_u==parent_v){
                        return true;
                    }
                    dsu.union(u,v);
                }
            }
        }
        return false;
        
    }
}
