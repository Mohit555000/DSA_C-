//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/

brute force approach
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
    
    public void preOrderTraversal(TreeNode root,ArrayList<TreeNode> list){
        if(root==null){
            return;
        }
        list.add(root);
        preOrderTraversal(root.left,list);
        preOrderTraversal(root.right,list);
    }
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        ArrayList<TreeNode> list=new ArrayList<>();
        preOrderTraversal(root,list);
        for(int i=0;i<list.size()-1;i++){
            TreeNode current=list.get(i);
            current.left=null;
            current.right=list.get(i+1);
        }
        TreeNode lastNode=list.get(list.size()-1);
        lastNode.left=null;
        lastNode.right=null;

    }
}


//optimized approach morris traversal of binary tree O(n) and space compexisty is O(1)
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
    public void flatten(TreeNode root) {
        TreeNode curr=root;
        while(curr!=null){
            //check if curr.left exit
            if(curr.left!=null){
                TreeNode previous=curr.left;

                //go to the right most node from the root's left node
                while(previous.right!=null){
                    previous=previous.right;
                }
                // 1. Connect the rightmost node's right pointer to the current right subtree
                previous.right=curr.right;
                // 2. Move the entire left subtree to the right side
                curr.right = curr.left;

                // 3. Set the left pointer to null
                curr.left = null;
            }
            // Move down to the next node on the right side
            curr = curr.right;
        }
    }
}
