//https://www.youtube.com/watch?v=9TJYWh0adfk&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=45
//https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
Property Of BST Trees - When we do inorder traversal traversal, we get elemnts in sorted way. (ascending order)
So we have used this property
//method 1 brute force approach
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
    public void inorder(TreeNode root,ArrayList<Integer> list){
        if(root==null){
            return;
        }
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list=new ArrayList<>();
        if(root==null){
            return -1;
        }
        inorder(root,list);
        return list.get(k-1);
    }
}


//Method 2 Optimized Approach
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
    int count=0;
    int ans=-1;
    public void inorder(TreeNode root,int k){
        if(root==null){
            return;
        }
        inorder(root.left,k);
        count++;
        if(count==k){
            ans=root.val;
            return;
        }
        inorder(root.right,k);
    }
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list=new ArrayList<>();
        ans=-1;
        count=0;
        if(root==null){
            return -1;
        }

        inorder(root,k);
        return ans;
    }
} 
