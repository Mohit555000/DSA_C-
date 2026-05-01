//https://leetcode.com/problems/same-tree/description/

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
    public boolean height(TreeNode root1,TreeNode root2){
        //if both are leaf nodes
        if(root1==null && root2==null) return true;
        //if either of them is leaf node
        if(root1==null || root2==null) return false;
        //if value is different
        if(root1.val!=root2.val) return false;

        return height(root1.left,root2.left) && height(root1.right,root2.right);

    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return height(p,q);
    }
}

ask chagpt for explanation
