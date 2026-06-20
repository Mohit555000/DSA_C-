//https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
//https://www.youtube.com/watch?v=0ql7lZS2qt0
class Solution {
    public void DFS(int u,ArrayList<ArrayList<Integer>> adj,boolean[] visited,ArrayList<Integer> result){
        if(visited[u]==true){
            return;
        }
        visited[u]=true;
        result.add(u);
        for(Integer v:adj.get(u)){
            if(visited[v]==false){
                DFS(v,adj,visited,result);
            }
        }
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        //To get the number of vertices if vertices are not given
        int V=adj.size();
        boolean visited[]=new boolean[V];
        ArrayList<Integer> result=new ArrayList<>();
        DFS(0,adj,visited,result);
        return result;
        
    }
}


//here the indexes are the actual vvertices so if you do adj.get(0) 0 here represent the index and in return we will get value
// present at index 0 like [1,2,3] so o is connected to its neighbour vertices [1,2,3 ] this continues so on and collectively we get a graph
