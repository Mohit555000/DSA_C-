class Solution {
    
    class Pair{
        int node;
        int weight;
        
        public Pair(int node,int weight){
            this.node=node;
            this.weight=weight;
        }
    }
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        Map<Integer,List<Pair>> adj=buildGraph(V,edges);
        
        return shortestDistance(V,adj,src);
    }
    public Map<Integer,List<Pair>> buildGraph(int V,int[][] edges){
        Map<Integer,List<Pair>> adj=new HashMap<>();
        
        for(int i=0;i<V;i++){
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
    public int[] shortestDistance(int V,Map<Integer,List<Pair>> adj,int src){
        int[] distance=new int[V];
        Arrays.fill(distance,Integer.MAX_VALUE);
        
        // Using Tree Set
        TreeSet<int[]> set=new TreeSet<>((a,b)->{
            // If distance is same of both the nodes then comapre the nodes if at 0th index distance is stored and at 1st index node is stored
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });
        distance[src]=0;
        set.add(new int[]{0,src});
        while(!set.isEmpty()){
            int[] current=set.pollFirst();
            
            int currentDistance=current[0];
            int node=current[1];
            
            for(Pair neighbour:adj.get(node)){
                int nextNode=neighbour.node;
                int edgeWeight=neighbour.weight;
                
                if(currentDistance+edgeWeight<distance[nextNode]){
                    // Remove the old entry
                    if(distance[nextNode]!=Integer.MAX_VALUE){
                        set.remove(new int[]{distance[nextNode],nextNode});
                    }
                    distance[nextNode]=currentDistance+edgeWeight;
                    
                    set.add(new int[]{distance[nextNode],nextNode});
                }
                
            }
        }
        return distance;
    }
}
