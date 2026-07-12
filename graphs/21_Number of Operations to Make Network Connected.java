//https://www.youtube.com/watch?v=q2xBd-D_1KQ&list=PLpIkg8OmuX-LZB9jYzbbZchk277H5CbdY&index=22
//https://leetcode.com/problems/number-of-operations-to-make-network-connected/description/

class Solution {
    class DUS{
        int[] parent;
        int[] rank;

        public DUS(int n){
            parent=new int[n];
            rank=new int[n];

            for(int i=0;i<n;i++){
                parent[i]=i;
                rank[i]=0;
            }
        }
        public int find(int x){
            if(parent[x]==x){
                return x;
            }
            return parent[x]=find(parent[x]);
        }
        public void union(int a,int b){
            int xParent=find(a);
            int yParent=find(b);

            if(rank[xParent]>rank[yParent]){
                parent[yParent]=xParent;
            } else if(rank[yParent]>rank[xParent]){
                parent[xParent]=yParent;
            }else{
                parent[xParent]=yParent;
                rank[yParent]++;
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        DUS dus=new DUS(n);
        int total_edges=connections.length;
        int minimum_edges=n-1;
        if(total_edges<minimum_edges){
            return -1;
        }
        int total_components=n;
        for(int[] connection:connections){
            int computer1=connection[0];
            int computer2=connection[1];

            int computer1_parent=dus.find(computer1);
            int computer2_parent=dus.find(computer2);
            if(computer1_parent!=computer2_parent){
                dus.union(computer1,computer2);
                total_components--;
            }
        }
        return total_components-1;
    }
}
