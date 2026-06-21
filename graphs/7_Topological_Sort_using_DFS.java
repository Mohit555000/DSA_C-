//https://www.geeksforgeeks.org/problems/topological-sort/1
//https://www.youtube.com/watch?v=WbbYZRr4arw&list=PLpIkg8OmuX-LZB9jYzbbZchk277H5CbdY&index=7

class Solution {
    public void DFS(int start,Map<Integer,List<Integer>> adj,boolean[] visited,Stack<Integer> st){
        //marking the start of the graph as true
        visited[start]=true;
        //fetching the negibhour
        
        for(int neighbour:adj.get(start)){
            if(visited[neighbour]==false){
                DFS(neighbour,adj,visited,st);
            }
        }
        st.add(start);
    }
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        //Creating adjacency list 
        Map<Integer,List<Integer>> adj=new HashMap<>();
        for(int i=0;i<V;i++){
            adj.put(i,new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            
            adj.get(u).add(v);
        }
        //creating a visited boolean array to cehck if node is already visited or not
        
        boolean[] visited=new boolean[V];
        ArrayList<Integer> ans=new ArrayList<>();
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<V;i++){
            if(visited[i]==false){
                DFS(i,adj,visited,st);
            }
        }
        while(!st.isEmpty()){
            int current=st.pop();
            ans.add(current);
        }
        return ans;
    }
}
