//https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftDepth=maxDepth(root.left);
        int rightDepth=maxDepth(root.right);
        return 1+Math.max(leftDepth,rightDepth);
    }

}

Complexity AnalysisTime Complexity: $O(N)$, where $N$ is the number of nodes in the tree. The algorithm has to visit every single node exactly once to find the maximum depth.Space Complexity: * Worst Case: $O(N)$ if the tree is completely unbalanced (skewed like a linked list), meaning the call stack will hold all nodes.Best/Average Case: $O(\log N)$ if the tree is balanced, because the maximum height of the call stack matches the height of the tree.
