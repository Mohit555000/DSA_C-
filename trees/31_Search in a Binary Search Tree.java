//https://leetcode.com/problems/search-in-a-binary-search-tree/description/

//Method 1
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
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null){
            return root;
        }
        TreeNode curr=root;
        if(curr.val!=val){
            if(val<curr.val){
                TreeNode leftChild=searchBST(curr.left,val);
                return leftChild;
            }
            if(val>curr.val){
                TreeNode rightChild=searchBST(curr.right,val);
                return rightChild;
            }
        }
        else{
            return curr;
        }
        return curr;
    }
}


//methdo 2
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
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode curr=root;
        if(root==null || root.val==val){
            return root;
        }
        while(curr!=null && curr.val!=val){
            if(val<curr.val){
                curr=curr.left;
            }
            else{
                curr=curr.right;
            }
        }
        return curr;
    }
}
