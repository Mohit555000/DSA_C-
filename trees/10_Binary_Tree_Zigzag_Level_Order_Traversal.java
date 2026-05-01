//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
//Method 1 brute force approach
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
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftSubTree=height(root.left);
        int rightSubTree=height(root.right);
        return 1+Math.max(leftSubTree,rightSubTree);
    }
    public void levelOrderTraversal(TreeNode root,int level,List<Integer> ans,boolean leftToRight){
        if(root==null) return;
        if(level==0){
            ans.add(root.val);
            return;
        }
        if(leftToRight){
            levelOrderTraversal(root.left,level-1,ans,leftToRight);
            levelOrderTraversal(root.right,level-1,ans,leftToRight);
        }
        else{
            levelOrderTraversal(root.right,level-1,ans,leftToRight);
            levelOrderTraversal(root.left,level-1,ans,leftToRight);
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();   
        int height=height(root);
        for(int i=0;i<height;i++){
            List<Integer> ans=new ArrayList<>();
            if(i%2==0){
                levelOrderTraversal(root,i,ans,true);
            }
            else{
                levelOrderTraversal(root,i,ans,false);
            }
            result.add(ans);
        }
        return result;
        
    }
}

//Metod 2 optimized approach
import java.util.*;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (leftToRight) {
                    level.add(node.val);              // normal add
                } else {
                    level.add(0, node.val);           // reverse add
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add(level);
            leftToRight = !leftToRight; // flip direction
        }

        return result;
    }
}

//get explanation from chatgpt
