//https://www.youtube.com/watch?v=cX_kPV_foZc&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=47
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        TreeNode curr=root;
        while(curr!=null){
            if(p.val<curr.val && q.val<curr.val){
                curr=curr.left;
            }
            else if(p.val>curr.val && q.val>curr.val){
                curr=curr.right;
            }
            else{
                return curr;
            }
        }
        return null;

    }
}
