//https://leetcode.com/problems/binary-search-tree-iterator/description/
//https://www.youtube.com/watch?v=D2jMcmxU4bs&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=50
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
class BSTIterator {
    ArrayList<Integer> list=new ArrayList<>();
    int i=-1;
    public boolean hasNextElement(){
        if(i+1<list.size()){
            return true;
        }
        return false;
    }
    public int returnNextElement(){
        i++;
        if(i>list.size()){
            return -1;
        }
        return list.get(i);
    }
    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
    public BSTIterator(TreeNode root) {
        inorder(root);
    }
    
    public int next() {
        int nextElement=returnNextElement();
        return nextElement;
    }
    
    public boolean hasNext() {
        boolean ans=hasNextElement();
        return ans;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
