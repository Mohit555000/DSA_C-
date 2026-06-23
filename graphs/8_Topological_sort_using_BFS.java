//this is also known as khan's algorithm
// /https://www.geeksforgeeks.org/problems/topological-sort/1
//https://www.youtube.com/watch?v=uVl4ftleTes&list=PLpIkg8OmuX-LZB9jYzbbZchk277H5CbdY&index=8
class Solution {
    public void BFS(int V,Map<Integer,List<Integer>> adj,int[] inorder,ArrayList<Integer> ans){
        // Step 4 Adding those element first whose inorder degree is 0
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(inorder[i]==0){
                q.add(i);
            }
        }
        //Step 5
        while(!q.isEmpty()){
            int currentElement=q.poll();
            ans.add(currentElement);
            
            for(int v:adj.get(currentElement)){
                inorder[v]--;
                
                if(inorder[v]==0){
                    q.add(v);
                }
            }
        }
        
    }
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        //Step 1 create adjacency list
        Map<Integer,List<Integer>> adj=new HashMap<>();
        for(int i=0;i<V;i++){
            adj.put(i,new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            
            adj.get(u).add(v);
        }
        // Step 2) Create inorder array
        int[] inorder=new int[V];
        for(int i=0;i<V;i++){
            for(int v:adj.get(i)){
                inorder[v]++;
            }
        }

        // Step 3) Simple BFS Now
        ArrayList<Integer> ans=new ArrayList<>();
        BFS(V,adj,inorder,ans);
        return ans;
    }
}
