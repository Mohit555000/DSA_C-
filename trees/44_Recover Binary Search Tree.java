//https://leetcode.com/problems/recover-binary-search-tree/description/
//https://www.youtube.com/watch?v=ZWGW7FminDM&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=52
//Brute Force Approach TC - O(nlog n) and SC - O(n)
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
    public void inorder(TreeNode root,ArrayList<TreeNode> nodes){
        if(root==null){
            return;
        }
        inorder(root.left,nodes);
        nodes.add(root);
        inorder(root.right,nodes);
    }
    public void recoverTree(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<>();
        ArrayList<TreeNode> nodes=new ArrayList<>();
        inorder(root,nodes);
        for(TreeNode node:nodes){
            list.add(node.val);
        }
        Collections.sort(list);
        for(int i=0;i<nodes.size();i++){
            nodes.get(i).val=list.get(i);
        }
    }
}

//Optimized Approach Time complexity is O(n) and space complexity is O(h)
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
    TreeNode first=null;
    TreeNode second=null;
    TreeNode prev=null;
    public void recoverTree(TreeNode root) {
        traverse(root);
        if(first!=null && second!=null){
            int temp=first.val;
            first.val=second.val;
            second.val=temp;
        }
    }
    public void traverse(TreeNode curr){
        if(curr==null){
            return;
        }
        traverse(curr.left);
        if(prev!=null && prev.val>curr.val){
            if(first==null){
                first=prev;
            }
            second=curr;
        }
        prev=curr;
        traverse(curr.right);
    }
}
