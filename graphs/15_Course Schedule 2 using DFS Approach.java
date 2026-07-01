//https://leetcode.com/problems/course-schedule-ii/
//https://www.youtube.com/watch?v=yiR95dxinjs&list=PLpIkg8OmuX-LZB9jYzbbZchk277H5CbdY&index=15
// This is the commbination of topological sort using DFS and cycle detection in a directed graph using DFS
import java.util.*;

class Solution {
    // 1. Changed return type to boolean to propagate cycle detection
    public boolean DFS(int start, Map<Integer, List<Integer>> adj, boolean[] visited,
                       boolean[] currentRecursion, Stack<Integer> st) {
        
        visited[start] = true;
        currentRecursion[start] = true;
        
        for (int v : adj.get(start)) {
            if (!visited[v]) {
                // If a child node detects a cycle, pass it up immediately
                if (DFS(v, adj, visited, currentRecursion, st)) {
                    return true;
                }
            } else if (currentRecursion[v]) {
                // If the node is already in the current recursion stack, a cycle exists
                return true;
            }
        }
        
        st.add(start);
        currentRecursion[start] = false; // Backtrack
        return false; // No cycle found in this path
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Step 1: Create adjacency list
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            int u = prerequisite[1];
            int v = prerequisite[0];
            adj.get(u).add(v); // Fixed: changed 'map' to 'adj'
        }
        
        boolean[] visited = new boolean[numCourses];
        boolean[] currentRecursion = new boolean[numCourses];
        Stack<Integer> st = new Stack<>();
        
        // Step 2: Detect cycle and build topological sort
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (DFS(i, adj, visited, currentRecursion, st)) {
                    return new int[0]; // Cycle detected, ordering is impossible
                }
            }
        }
        
        // Step 3: Pop elements from stack to get the correct order
        int i = 0;
        int[] finalAns = new int[numCourses];
        while (!st.isEmpty()) {
            finalAns[i++] = st.pop();
        }
        
        return finalAns;
    }
}
