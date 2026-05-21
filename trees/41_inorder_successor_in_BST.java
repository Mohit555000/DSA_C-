//https://www.youtube.com/watch?v=SXKAD2svfmI&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=49
//https://www.geeksforgeeks.org/problems/inorder-successor-in-bst/1

//Brute Force 1) Appraoch Time complextiy is O(n) (bca of exploring all the nodes in tree) +O(n) (for linear search) and space complexity is O(n) (we are storing the inorder traversal element in arraylist)
/*
Definition for Node
class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int val) {
        data = val;
        left = right = null;
    }
};
*/

class Solution {
    public void inorder(Node root,ArrayList<Integer> list){
        if(root==null){
            return;
        }
        inorder(root.left,list);
        list.add(root.data);
        inorder(root.right,list);
        
    }
    public int inOrderSuccessor(Node root, Node k) {
        if(root==null){
            return -1;
        }
        // code here
        ArrayList<Integer> list=new ArrayList<>();
        inorder(root,list);
        for(int i=0;i<list.size();i++){
            if(list.get(i)>k.data){
                return list.get(i);
            }
        }
        return -1;
        
    }
}

//Appraoch 2 Time complexity is O(n) and space complexity is O(1)
/*
Definition for Node
class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int val) {
        data = val;
        left = right = null;
    }
};
*/

class Solution {
    
    public int inorder(Node root,Node k){
        if(root==null){
            return -1;
        }
        int leftTree=inorder(root.left,k);
        if(leftTree!=-1){
            return leftTree;
        }
        if(root.data>k.data){
            return root.data;
        }
        int rightTree=inorder(root.right,k);
        if(rightTree!=-1){
            return rightTree;
        }
        return -1;
        
    }
    public int inOrderSuccessor(Node root, Node k) {
        // code here
        return inorder(root,k);
        
    }
}

//Approach 3 time complexity O(h) h=height of the tree and space complexity O(1)
/*
Definition for Node
class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int val) {
        data = val;
        left = right = null;
    }
};
*/

class Solution {
    public int inOrderSuccessor(Node root, Node k) {
        // code here
        if(root==null){
            return -1;
        }
        Node curr=null;
        while(root!=null){
            if(k.data>=root.data){
                root=root.right;
            }
            else{
                curr=root;
                root=root.left;
            }
        }
        if(curr==null){
            return -1;
        }
        return curr.data;
    }
}
