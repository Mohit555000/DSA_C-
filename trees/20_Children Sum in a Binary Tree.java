//https://www.geeksforgeeks.org/problems/children-sum-parent/1
/*
class Node{
    int data;
    Node left,right;

    Node(int key)
    {
        data = key;
        left = right = null;
    }
}
*/
class Solution {
    public boolean isSumProperty(Node root) {
        //  code here
        if(root==null || (root.left==null&&root.right==null)){
            return true;
        }
        int sum=0;
        if(root.left!=null){
            sum=sum+root.left.data;
        }
        if(root.right!=null){
            sum=sum+root.right.data;
        }
        if(root.data==sum && isSumProperty(root.left)&& isSumProperty(root.right)){
            return true;
        }
        else{
            return false;
        }
    }
}
