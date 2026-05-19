//https://leetcode.com/problems/validate-binary-search-tree/description/
//https://youtu.be/f-sj7I5oXEI?si=SQJtoNw7BYjzlvvi


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
    public boolean validate(TreeNode root,long min,long max){
      // Base case: An empty tree/node is always a valid BST
        if(root==null){
            return true;
        }
      //// If the current node's value violates the strict BST constraints
        if(root.val<=min || root.val>=max){
            return false;
        }
      // Recursively check the subtrees with updated bounds:
        // Left subtree values must be strictly less than node.val
        // Right subtree values must be strictly greater than node.val
        return validate(root.left,min,root.val) && validate(root.right,root.val,max);
    }
    public boolean isValidBST(TreeNode root) {
      //// We start with the absolute widest possible range
        return validate(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
}
