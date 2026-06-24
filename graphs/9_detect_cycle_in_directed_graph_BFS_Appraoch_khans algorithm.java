// /https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
//https://www.youtube.com/watch?v=74suJP4bwf0&list=PLpIkg8OmuX-LZB9jYzbbZchk277H5CbdY&index=9

class Solution {
    int count=0;
    public void BFS(int V, Map<Integer, List<Integer>> adj,int[] inorder){
        //Step 4 Add those elemnts first in queue whose inorder is zero
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(inorder[i]==0){
                q.add(i);
            }
        }
        //step 5
        while(!q.isEmpty()){
            int currentElement=q.poll();
            count++;
            
            for(int v:adj.get(currentElement)){
                inorder[v]--;
                
                if(inorder[v]==0){
                    q.add(v);
                }
            }
        }
    }
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        //Step 1 create adjacence list
        Map<Integer, List<Integer>> adj=new HashMap<>();
        for(int i=0;i<V;i++){
            adj.put(i,new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            
            adj.get(u).add(v);
        }
        
        //Step 2 create inorder array
        int[] inorder=new int[V];
        for(int i=0;i<V;i++){
            for(int neighbour:adj.get(i)){
                inorder[neighbour]++;
            }
        }
        
        //Step 3 Simple BFS Now
        BFS(V,adj,inorder);
        if(count==V){
            return false;
        }
        else{
            return true;
        }
    }
}
