// https://www.youtube.com/watch?v=K_LamGUvwUc&list=PLpIkg8OmuX-LZB9jYzbbZchk277H5CbdY&index=6  (first watch this)
// https://www.youtube.com/watch?v=GLxfoaZlRqs (Then watch this)
//https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1

class Solution {
    public boolean DFS(int start,Map<Integer,List<Integer>> adj,boolean[] visited,boolean[] currentRecursion){
        visited[start]=true; //since we are staring from this to it is marked as true
        currentRecursion[start]=true; //Part of the current recursion state
        
        for(int neighbour : adj.get(start)){ //fetching th enighbours of current node
            if(visited[neighbour]==false){
                if(DFS(neighbour,adj,visited,currentRecursion)==true){
                    return true;
                }
            }
            else if(currentRecursion[neighbour]==true){
                return true;
            }
        }
        currentRecursion[start]=false;
        return false;
    }
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        //convert the edges into a adjaceny list
        Map<Integer,List<Integer>> adj=new HashMap<>();
        for(int i =0;i<V;i++){
            adj.put(i,new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            
            adj.get(u).add(v);
        }
        boolean[] visited=new boolean[V]; //to cehck whether the node is visited or npt
        boolean[] currentRecursion=new boolean[V]; //to check whether the node is present in the current recursion
        
        for(int i=0;i<V;i++){
            if(visited[i]==false){ //if the current elemnt is not visited
                if(DFS(i,adj,visited,currentRecursion)==true){
                    return true;
                }
            } 
            
        }
        return false;
    }
}
