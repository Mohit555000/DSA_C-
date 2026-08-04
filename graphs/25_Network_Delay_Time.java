//https://leetcode.com/problems/network-delay-time/description/
//https://www.youtube.com/watch?v=hptQEIpvaxM&list=PLpIkg8OmuX-LZB9jYzbbZchk277H5CbdY&index=28

// It is exactly Dijkstra algorithm and we need to just return the maximum element from the distacne array and that will be the answe
// Rest of the code is exactly same as the normal dijkstra's algorithm


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
        Map<Integer,List<Pair>> adj=new HashMap<>();
        for(int i=1;i<=V;i++){
            adj.put(i,new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];

            adj.get(u).add(new Pair(v,w));
            // adj.get(v).add(new Pair(u,w));
        }
        return adj;
    }
    public int find(Map<Integer,List<Pair>> adj,int src,int V){
        int[] distance=new int[V+1];
        int maxElement=Integer.MIN_VALUE;
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[src]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.weight-b.weight);
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

                if(edgeWeight+currentDistance<distance[nextNode]){
                    distance[nextNode]=edgeWeight+currentDistance;
                    pq.offer(new Pair(nextNode,distance[nextNode]));
                }
            }
        }
        for(int i=1;i<=V;i++){
            if(distance[i]==Integer.MAX_VALUE){
                return -1;
            }
            if(distance[i]>maxElement){
                maxElement=distance[i];
            }
        }
        return maxElement;
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,List<Pair>> adj=buildGraph(times,n);
        return find(adj,k,n);
    }
}
