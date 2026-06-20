//https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
//https://www.youtube.com/watch?v=dCvnjapI6ik
class Solution {
    public void BFS(int start,ArrayList<ArrayList<Integer>> adj,boolean[] visited,ArrayList<Integer> result){
        Queue<Integer> q=new LinkedList<>();
        visited[start]=true;
        q.offer(start);
        while(!q.isEmpty()){
            int u=q.poll();
            result.add(u);
            for(int v:adj.get(u)){
                if(visited[v]==false){
                    visited[v]=true;
                    q.offer(v);
                }
            }
        }
    }
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        Queue<Integer> q=new LinkedList<>();
        int V=adj.size();
        boolean[] visited=new boolean[V];
        ArrayList<Integer> result=new ArrayList<>();
        BFS(0,adj,visited,result);
        return result;
    }
}
