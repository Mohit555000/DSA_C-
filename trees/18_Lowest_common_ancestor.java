//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
//https://www.youtube.com/watch?v=_-QHfMDde90
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//brute force apprach
//Time complexity is O(n) and Space Compleit is O(Tree height)
class Solution {
    public boolean helper(TreeNode root,TreeNode p,ArrayList<TreeNode> path){
        if(root==null){
            return false;
        }
        path.add(root);
        if(root==p){
            return true;
        }
        if(helper(root.left,p,path)||helper(root.right,p,path)){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> path1=new ArrayList<>();
        ArrayList<TreeNode> path2=new ArrayList<>();
        helper(root,p,path1);
        helper(root,q,path2);
        TreeNode lca=null;
        int minLength=Math.min(path1.size(),path2.size());
        for(int i=0;i<minLength;i++){
            if(path1.get(i)==path2.get(i)){
                lca=path1.get(i);
            }
            else{
                break;
            }
        }
        return lca;

    }
}
//Optimized apprach 
//Time complexity will be O(n) and No extra space has been used.
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
        if(root==null || root==p || root==q){
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);

        if(left!=null && right!=null){
            return root;
        }
        if(left==null){
            return right;
        }
        else{
            return left;
        }
        
    }
} 

first solve root to a given node path sum then you will understand this sum
