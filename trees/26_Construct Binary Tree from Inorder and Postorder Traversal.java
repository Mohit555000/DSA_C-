//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
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
    int postOrderIndex;
    public int search(int[] inorder,int left,int right,int value){
        for(int i=left;i<=right;i++){
            if(inorder[i]==value){
                return i;
            }
        }
        return -1;
    }
    public TreeNode helper(int[] inorder, int[] postorder,int left,int right){
        if(left>right){
            return null;
        }
        TreeNode root=new TreeNode(postorder[postOrderIndex]);
        int searchIndex=search(inorder,left,right,postorder[postOrderIndex]);
        postOrderIndex--;

        root.right=helper(inorder,postorder,searchIndex+1,right);
        root.left=helper(inorder,postorder,left,searchIndex-1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postOrderIndex=postorder.length-1;
        return helper(inorder,postorder,0,inorder.length-1);
    }
}

problem 25 and 26 are almost similar first solve 25 and then 26.
