//https://leetcode.com/problems/symmetric-tree/description/
//See vide for just visualization https://www.youtube.com/watch?v=nKggNAiEpBE&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=25 or smj raha hai toh thek hai 
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
    public boolean compare(TreeNode left,TreeNode right){
        if(left==null && right==null) return true;
        if(left==null || right==null) return false;
        if(left.val!=right.val) return false;

        return compare(left.left,right.right) && compare(left.right,right.left); 
    }
    public boolean isSymmetric(TreeNode root) {
        boolean ans=compare(root.left,root.right);
        return ans;
    }
}
A binary tree is symmetric if the left subtree is the mirror image of the right subtree.
To check this, we compare two nodes at the same time:


If both nodes are null, then that small subtree is symmetric.


If one node is null and the other is not, then the subtree is not symmetric.


If both nodes exist but their values are different, then the subtree is not symmetric.


If the values are the same, we move deeper and check:


left child of the first node with right child of the second node


right child of the first node with left child of the second node




Using recursion, we continue checking all smaller mirrored subtrees.
If every comparison satisfies the symmetry conditions, then the entire tree is symmetric.
In simple terms:

We keep moving deeper into the tree and verify whether each left-side subtree is the mirror image of the corresponding right-side subtree.
