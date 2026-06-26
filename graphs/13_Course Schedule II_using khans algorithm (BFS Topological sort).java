//https://leetcode.com/problems/course-schedule-ii/description/
//https://www.youtube.com/watch?v=W1WhSN9wAw0&list=PLpIkg8OmuX-LZB9jYzbbZchk277H5CbdY&index=13

class Solution {
    public void BFS(int numCourses,ArrayList<Integer> ans,Map<Integer,List<Integer>> adj,int[] inorder){
        // Step 4 Adding those element first whose inorder degree is 0
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inorder[i]==0){
                q.add(i);
            }
        }
        // step 5
        while(!q.isEmpty()){
            int currentElement=q.poll();
            ans.add(currentElement);

            for(int v:adj.get(currentElement)){
                inorder[v]--;

                if(inorder[v]==0){
                    q.add(v);
                }
            }
        }
        
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // we have to just perfrom topological sort (khan's algorithm)
        // Step1 create the adjacency list
        Map<Integer,List<Integer>> adj=new HashMap<>();
        for(int i =0;i<numCourses;i++){
            adj.put(i,new ArrayList<>());
        }
        for(int[] prerequisite:prerequisites){
            int u=prerequisite[1];
            int v=prerequisite[0];

            adj.get(u).add(v);
        }
        // Step 2) Create inorder array
        int[] inorder=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int v:adj.get(i)){
                inorder[v]++;
            }
            
        }
        // Step 3) Simple BFS Now
        ArrayList<Integer> ans=new ArrayList<>();
        int[] finalAns=new int[numCourses];
        BFS(numCourses,ans,adj,inorder);
        if(ans.size()==numCourses){
            for(int i=0;i<numCourses;i++){
                finalAns[i]=ans.get(i);
            }
            return finalAns;
        } 
        return new int[0];
    }
}
