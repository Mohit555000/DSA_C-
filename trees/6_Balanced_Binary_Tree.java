//https://leetcode.com/problems/balanced-binary-tree/
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
    public int heightOfTree(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftSub=heightOfTree(root.left);
        int rightSub=heightOfTree(root.right);

        return 1+Math.max(leftSub,rightSub);
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        int left=heightOfTree(root.left);
        int right=heightOfTree(root.right);

        if(Math.abs(left-right)>1) return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }
    
}
