https://www.geeksforgeeks.org/problems/shortest-path-in-weighted-undirected-graph/1
//This is the foundation; I have not implemented the lexicographical part of the solution.

class Solution {
    
    class Pair{
        int node;
        int weight;
        
        public Pair(int node,int weight){
            this.node=node;
            this.weight=weight;
        }
    }
    public Map<Integer,List<Pair>> buildGraph(int V,int[][] edges){
        Map<Integer,List<Pair>> adj=new HashMap<>();
        for(int i=0;i<=V;i++){
            adj.put(i,new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }
        return adj;
    }
    public void dijkstra(Map<Integer,List<Pair>> adj,int src,int[] distance,int[] parent,int V){
        Arrays.fill(distance,Integer.MAX_VALUE);
        for(int i=1;i<=V;i++){
            parent[i]=i;
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.weight-b.weight);
        distance[src]=0;
        pq.offer(new Pair(src,0));
        while(!pq.isEmpty()){
            Pair current=pq.poll();
             int node=current.node;
             int currentDistance=current.weight;
             if(currentDistance>distance[node]){
                 continue;
             }
             for(Pair neighbour:adj.get(node)){
                 int nextNode=neighbour.node;
                 int edgeWeight=neighbour.weight;
                 
                 if(currentDistance+edgeWeight<distance[nextNode]){
                     distance[nextNode]=currentDistance+edgeWeight;
                     parent[nextNode]=node;
                     pq.offer(new Pair(nextNode,distance[nextNode]));
                 }
             }
        }
    }
    public ArrayList<Integer> getPath(int src,int dest,int[] parent){
        ArrayList<Integer> ans=new ArrayList<>();
        int current=dest;
        while(current!=parent[current]){
            ans.add(current);
            current=parent[current];
        }
        ans.add(src);
        Collections.reverse(ans);
        return ans;
    }
    public ArrayList<Integer> shortestPath(int V, int[][] edges, int src, int dest) {
        // code here
        Map<Integer,List<Pair>> adj=buildGraph(V,edges);
        int[] distance=new int[V+1];
        int[] parent=new int[V+1];
        
        dijkstra(adj,src,distance,parent,V);
        
        if(distance[dest]==Integer.MAX_VALUE){
            ArrayList<Integer> ans=new ArrayList<>();
            ans.add(-1);
            return ans;
        }
        return getPath(src,dest,parent);
    }
}
