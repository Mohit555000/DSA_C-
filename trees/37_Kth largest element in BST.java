//https://www.geeksforgeeks.org/problems/kth-largest-element-in-bst/1
Property Of BST Trees - When we do inorder traversal traversal, we get elemnts in sorted way. (ascending order)
So we have used this property
//brute force approach
/*
class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class Solution {
    // return the Kth largest element in the given BST rooted at 'root'
    public void inorder(Node root,ArrayList<Integer>list){
        if(root==null){
            return;
        }
        inorder(root.left,list);
        list.add(root.data);
        inorder(root.right,list);
    }
    public int kthLargest(Node root, int k) {
        // Your code here
        if(root==null){
            return -1;
        }
        ArrayList<Integer> list=new ArrayList<>();
        inorder(root,list);
        Collections.sort(list);
        return list.get(list.size()-k);
    }
}


//Optimized Approach
/*
class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class Solution {
    int ans=-1;
    int count=0;
    // return the Kth largest element in the given BST rooted at 'root'

    public void inorder(Node root,int k){
        if(root==null){
            return;
        }
        inorder(root.right,k);
        count++;
        if(count==k){
            ans=root.data;
        }
        inorder(root.left,k);
    }
    public int kthLargest(Node root, int k) {
        // Your code here
        if(root==null){
            return -1;
        }
        inorder(root,k);
        return ans;
    }
}
