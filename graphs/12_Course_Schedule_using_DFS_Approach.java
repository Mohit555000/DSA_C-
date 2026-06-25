// https://leetcode.com/problems/course-schedule/description/
// https://www.youtube.com/watch?v=lqjlGGMjSMU&list=PLpIkg8OmuX-LZB9jYzbbZchk277H5CbdY&index=12   ismai khan's algorithm approach use kiya hai 
class Solution {
    public boolean DFS(int start,Map<Integer,List<Integer>> adj,boolean[] visited,boolean[] currentRecursion){
        visited[start]=true;
        currentRecursion[start]=true;

        for(int neighbour:adj.get(start)){
            if(visited[neighbour]==false){
                if(DFS(neighbour,adj,visited,currentRecursion)==true){
                    return true;
                }
            } else if(currentRecursion[neighbour]==true){
                return true;
            }
        }
        currentRecursion[start]=false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //make the adjacencey list
        Map<Integer,List<Integer>> adj=new HashMap<>();
        for(int i=0;i<numCourses;i++){
            adj.put(i,new ArrayList<>());
        }
        for(int[] prerequisite:prerequisites){
            int u=prerequisite[1];
            int v=prerequisite[0];

            adj.get(u).add(v); //since it is a directed graph
        }
        boolean[] visited=new boolean[numCourses];
        boolean[] currentRecursion=new boolean[numCourses];

        for(int i=0;i<numCourses;i++){
            if(visited[i]==false){
                if(DFS(i,adj,visited,currentRecursion)==true){
                    return false;
                }
            }
        }
        return true;
    }
}
