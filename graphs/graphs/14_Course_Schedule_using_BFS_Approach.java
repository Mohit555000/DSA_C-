// https://leetcode.com/problems/course-schedule/

class Solution {
    int count=0;
    public void BFS(int numCourses,Map<Integer,List<Integer>> adj,int[] inorder){
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inorder[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int currentElement=q.poll();
            count++;
            for(int neighbour:adj.get(currentElement)){
                inorder[neighbour]--;
                if(inorder[neighbour]==0){
                    q.add(neighbour);
                }
                
            }
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step1 create the adjacency list
        Map<Integer,List<Integer>> adj=new HashMap<>();
        for(int i=0;i<numCourses;i++){
            adj.put(i,new ArrayList<>());
        }
        for(int[] prerequisite:prerequisites){
            int u=prerequisite[1];
            int v=prerequisite[0];

            adj.get(u).add(v);
        }
        // STep 2 create inorder array since we are using BFS. if there s a loop then no lectures can be covered.
        int[] inorder=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int neighbour:adj.get(i)){
                inorder[neighbour]++;
            }
        }
        // Step 3 now simple BFS Traversal
        BFS(numCourses,adj,inorder);
        if(count==numCourses){
            return true;
        }
        return false;
    }
}
