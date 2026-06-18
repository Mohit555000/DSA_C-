class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       Map<Integer,List<Integer>> adj=new HashMap<>();
       for(int[] relation:prerequisites){
            int v=relation[1];
            int u=relation[0];

            map.putIfAbsent(u,new ArrayList<>());
            map.get(u).add(v);
       } 
    }
}