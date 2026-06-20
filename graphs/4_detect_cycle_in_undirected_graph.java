//For concept explanation (since it is in java langauge) https://www.youtube.com/watch?v=UPfUFoWjk5w&t=512s
// Following this playlist for solving questions https://www.youtube.com/watch?v=UrQv5YMC060&list=PLpIkg8OmuX-LZB9jYzbbZchk277H5CbdY&index=4

class Solution {
    public boolean dfs(int start,int parent,Map<Integer,List<Integer>> adj,boolean[] visited){
        visited[start]=true;
        for(int neighbour:adj.get(start)){
            if(visited[neighbour]==false){
                if(dfs(neighbour,start,adj,visited)==true){
                    return true;
                }
            }
            else if(neighbour!=parent){
                return true;
            }
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        Map<Integer,List<Integer>> adj=new HashMap<>();
        
        //Initializing all the vertices
        for(int i=0;i<V;i++){
            adj.put(i,new ArrayList<>());
        }
        //Converting edge list into adjadency list
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u); //unidirected graph
            
        }
        boolean[] visited=new boolean[V];
        //ye wala loop iseliye use kar rhe hai bcz it is possible ki there are multiple graphs which are not connected to each other and to cover all those graphs we have iterate all over them
        
        for(int i=0;i<V;i++){
            if(visited[i]==false){
                if(dfs(i,-1,adj,visited)==true){
                    return true;
                }
            }
        }
        return false;
    }
}
