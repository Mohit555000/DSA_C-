//https://www.geeksforgeeks.org/problems/bipartite-graph/1
//https://www.youtube.com/watch?v=NeU-C1PTWB8&list=PLpIkg8OmuX-LZB9jYzbbZchk277H5CbdY&index=16

class Solution {
    public boolean DFS(int currentNode,Map<Integer,List<Integer>> adj,int[] colour,int currentColour){
        colour[currentNode]=currentColour;
        for(int neighbour:adj.get(currentNode)){
            if(colour[neighbour]==-1){
                int newColour=1-currentColour;
                    if(DFS(neighbour,adj,colour,newColour)==false){
                        return false;
                    }
            }
                else if(colour[neighbour]==colour[currentNode]){
                    return false;
                }
            }
            return true;
        }
        
    public boolean isBipartite(int V, int[][] edges) {
        // Code here
        //Step 1 create adjacency list
        Map<Integer,List<Integer>> adj=new HashMap<>();
        for(int i=0;i<V;i++){
            adj.put(i,new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u); //since it is an undirected graph;
        }
        // Step 2 Create and initialize the colour array
        int[] colour=new int[V];
        for(int i=0;i<V;i++){
            colour[i]=-1;
        }
        
        // Step 3 Call DFS
        for(int i=0;i<V;i++){
            if(colour[i]==-1){
                if(DFS(i,adj,colour,0)==false){
                    return false;
                }
            }
        }
        return true;
    }
    
}
