// https://leetcode.com/problems/course-schedule/description/
// https://www.youtube.com/watch?v=lqjlGGMjSMU&list=PLpIkg8OmuX-LZB9jYzbbZchk277H5CbdY&index=12   ismai khan's algorithm use kiya hai 
class Solution {
    public void BFS(int start,Map<Integer,List<Integer>> adj,boolean[] visited){
        Queue<Integer> q=new LinkedList<>();
        visited[start]=true;
        q.add(start);
        while(!q.isEmpty()){
            int currentElement=q.poll();
            for(int neighbour:adj.get(start)){
                if(visited[neighbour]==false){
                    BFS(neighbour,adj,visited);
                }
            }
        }

    }
    public int findCircleNum(int[][] isConnected) {
        Map<Integer,List<Integer>> adj=new HashMap<>();
        int m=isConnected.length;
        int n=isConnected[0].length;
        // Create Map
        for(int i=0;i<m;i++){
            adj.put(i,new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i!=j && isConnected[i][j]==1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int count=0;
        boolean[] visited=new boolean[m];
        for(int i=0;i<m;i++){
            if(visited[i]==false){
                BFS(i,adj,visited);
                count++;
            }
        }
        return count;
    }
}
