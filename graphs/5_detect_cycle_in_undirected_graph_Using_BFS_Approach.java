//Refer Question 4 first then refer this
//https://www.youtube.com/watch?v=HqIQmKKo5_I&list=PLpIkg8OmuX-LZB9jYzbbZchk277H5CbdY&index=5

Time complexity is O(V+E)
Space Complexity is O(V+E)

class Solution {
    class Pair{
        int node;
        int parent;
        
        Pair(int node,int parent){
            this.node=node;
            this.parent=parent;
        }
    }
    public boolean BFS(int start,Map<Integer,List<Integer>> adj,boolean[] visited){
        Queue<Pair> q=new LinkedList<>();
        // Starting node ko visit mark karo aur queue mein daalo (-1 parent ke saath)
        visited[start]=true;
        q.add(new Pair(start,-1));
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int u=curr.node;
            int p=curr.parent;
            
            //check all the neighbours
            for(int v:adj.get(u)){
                // Case 1: Agar neighbour visited nahi hai
                if(visited[v]==false){
                    visited[v]=true;
                    q.add(new Pair(v,u));
                }
                // Case 2: Agar neighbour visited hai AUR woh parent nahi hai
                // Iska matlab koi aur rasta bhi hai is node tak pahunchne ka -> Cycle Detected!
                else if(v!=p){
                    return true;
                }
            }
            
        }
        return false;
        
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        Map<Integer,List<Integer>> adj=new HashMap<>();
        for(int i=0;i<V;i++){
            adj.put(i,new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u); //Since undirected Graph
        }
        boolean[] visited=new boolean[V];
        for(int i=0;i<V;i++){
            if(visited[i]==false){
                if(BFS(i,adj,visited)==true){
                    return true;
                }
            }
        }
        return false;
    }
}
