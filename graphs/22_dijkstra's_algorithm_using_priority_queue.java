//https://www.youtube.com/watch?v=xQ3vjWwFRuI&list=PLpIkg8OmuX-LZB9jYzbbZchk277H5CbdY&index=24
//https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
class Solution {
    class Pair{
        int node;
        int weight;
        
        public Pair(int node,int weight){
            this.node=node;
            this.weight=weight;
        }
    }
    public Map<Integer,List<Pair>> buildGraph(int[][] edges,int V){
        Map<Integer, List<Pair>> adj = new HashMap<>();

        for (int i = 0; i < V; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }
        return adj;
    }
    public int[] findShortestDistamce(int V,Map<Integer,List<Pair>> adj,int src){
        int[] distance=new int[V];
        Arrays.fill(distance,Integer.MAX_VALUE);
        
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
                int edgeWidth=neighbour.weight;
                
                if(currentDistance+edgeWidth<distance[nextNode]){
                    distance[nextNode]=currentDistance+edgeWidth;
                    pq.offer(new Pair(nextNode,distance[nextNode]));
                }
            }
            
        }
        return distance;
    }
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        Map<Integer,List<Pair>> adj=buildGraph(edges,V);
        
        return findShortestDistamce(V,adj,src);
        
    }
    
