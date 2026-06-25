// /https://leetcode.com/problems/number-of-provinces/description/
https://www.youtube.com/watch?v=70LNE8RMPNc&list=PLpIkg8OmuX-LZB9jYzbbZchk277H5CbdY&index=10
class Solution {
    int count=0;
    public void DFS(int start,Map<Integer,List<Integer>> adj,boolean[] visited){
        visited[start]=true;
        for(int v:adj.get(start)){
            if(visited[v]==false){
                DFS(v,adj,visited);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        //Step 1 create adjacency list TC is O(V+E);
        Map<Integer,List<Integer>> adj=new HashMap<>();
        int V=isConnected.length;
        for(int i=0;i<V;i++){
            adj.put(i,new ArrayList<>());
        }
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(i!=j && isConnected[i][j]==1){
                    adj.get(i).add(j);
                }
            }
        }
        // Step 2 crate visited array
        boolean[] visited=new boolean[V];
        for(int i=0;i<V;i++){
            if(visited[i]==false){
                DFS(i,adj,visited);
                count++;
            }
        }
        return count;
    }
}
