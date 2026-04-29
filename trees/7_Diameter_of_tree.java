//https://leetcode.com/problems/diameter-of-binary-tree/

//Method 1 (Brute FOrce Approach)
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
    int diameter=0;
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftSubTree=height(root.left);
        int rightSubTree=height(root.right);

        return 1+Math.max(leftSubTree,rightSubTree);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftSubTree=height(root.left);
        int rightSubTree=height(root.right);

        diameter=Math.max(diameter,leftSubTree+rightSubTree);
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        
        return diameter;
    }
}

//Method 2 (Optimized Approach)
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
    int diameter=0;
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftSubTree=height(root.left);
        int rightSubTree=height(root.right);
        diameter=Math.max(diameter,leftSubTree+rightSubTree);
        return 1+Math.max(leftSubTree,rightSubTree);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;

    }
}

optimized solution
   ask chagpt to understand the logic
