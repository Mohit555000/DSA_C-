//https://leetcode.com/problems/count-complete-tree-nodes/description/
//https://www.youtube.com/watch?v=u-yWemKGWO0&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=32
For this problem we can do any type of traversal and find the number of nodes.
method 1
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
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1+countNodes(root.left)+countNodes(root.right);
    }
}


//method 2
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
    public int countNodes(TreeNode root) {
        int count=0;
        Queue<TreeNode> q=new ArrayDeque<>();
        if(root==null){
            return 0;
        }
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            count++;

            if(curr.left!=null){
                q.add(curr.left);
            }
            if(curr.right!=null){
                q.add(curr.right);
            }
        }
        return count;
    }
}

              //method 3 optimized approach
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
    public int leftheight(TreeNode root){
        int count=0;
        if(root==null){
            return 0;
        }
        while(root!=null){
            count++;
            root=root.left;
        }
        return count;
    }
    public int rightheight(TreeNode root){
        int count=0;
        if(root==null){
            return 0;
        }
        while(root!=null){
            count++;
            root=root.right;
        }
        return count;
    }
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftHeight=leftheight(root);
        int rightHeight=rightheight(root);

        if(leftHeight==rightHeight){
            return (int)Math.pow(2,rightHeight)-1;
        }
        else{
            return 1+countNodes(root.left)+countNodes(root.right);
        }
    }
}
