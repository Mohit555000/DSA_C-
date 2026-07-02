//https://leetcode.com/problems/is-graph-bipartite/
//https://www.youtube.com/watch?v=cvhXZt66VhA&list=PLpIkg8OmuX-LZB9jYzbbZchk277H5CbdY&index=17

class Solution {
    public boolean BFS(int currentNode,int[][] graph,int[] colour,int currentColour){
        Queue<Integer> q=new LinkedList<>();
        colour[currentNode]=currentColour;
        q.add(currentNode);
        while(!q.isEmpty()){
            int currentElement=q.poll();
            for(int neighbour:graph[currentElement]){
                if(colour[neighbour]==colour[currentElement]){
                    return false;
                }
                else if(colour[neighbour]==-1){
                    int newColour=1-colour[currentElement];
                    colour[neighbour]=newColour;
                    q.add(neighbour);
                }
            }
        }
        return true;
        
    }
    public boolean isBipartite(int[][] graph) {
        //step 1 create adjacency list
        // Map<Integer,List<Integer>> adj=new HashMap<>();
        int V=graph.length;
        // for(int i=0;i<V;i++){
        //     adj.put(i,new ArrayList<>());
        // }
        // for(int[] edge:graph){
        //     int u=edge[0];
        //     int v=edge[1];

        //     adj.get(u).add(v);
        //     adj.get(v).add(u);
        // }
        //createing colour array
        int[] colour=new int[V];
        for(int i=0;i<V;i++){
            colour[i]=-1;
        }
        // calling the BFS Function
        for(int i=0;i<V;i++){
            if(colour[i]==-1){
                if(BFS(i,graph,colour,1)==false){
                    return false;
                }
            }
        }
        return true;
    }
}
