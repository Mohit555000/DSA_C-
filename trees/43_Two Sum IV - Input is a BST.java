//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/

//Brute Force Approach  space complexity is O(n) Time complexity is O(n) for inorder traversal then O(n^2) for finding the pair
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
    public boolean findTarget(TreeNode root, int k) {
        if(root==null){
            return false;
        }
        ArrayList<Integer> list=new ArrayList<>();
        inorder(root,list);
        for(int i=0;i<list.size();i++){
            for(int j=0;j<list.size();j++){
                if(list.get(i)+list.get(j)==k && i!=j){
                    return true;
                }
            }
        }
        return false;

    }
}

//optimized approach 1  used set this reduced the search time from O(n^2) to almost O(1) to TC is O(n) for inorder traversal and space complexity is also O(1)

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
    public boolean inorder(TreeNode root,HashSet<Integer> set,int k){
        if(root==null){
            return false;
        }
        boolean left=inorder(root.left,set,k);
        if(set.contains(k-root.val)){
            return true;
        }
        set.add(root.val);
        boolean right=inorder(root.right,set,k);
        return left|| right;
    }
    public boolean findTarget(TreeNode root, int k) {
        if(root==null){
            return false;
        }
        HashSet<Integer> set=new HashSet<>();
        boolean ans=inorder(root,set,k);
        return ans;

    }
}


//optimized approach 2 without useing hash set. Used Two Pointer Apporach
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
    public boolean findTarget(TreeNode root, int k) {
        if(root==null){
            return false;
        }
        ArrayList<Integer> list=new ArrayList<>();
        inorder(root,list);
        int i=0;
        int j=list.size()-1;
        while(i<j){
            if(list.get(i)+list.get(j)==k){
                return true;
            }
            else if(list.get(i)+list.get(j)>k){
                j--;
            }
            else{
                i++;
            }
        }
        return false;

    }
}


Need to revise the morris traversal and its related sum to solve this sum in optimized way
  
