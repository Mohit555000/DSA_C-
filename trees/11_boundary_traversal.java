//https://www.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1
//https://www.youtube.com/watch?v=0ca1nvR0be4&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=20
/*
class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    void addRightBoundary(Node root,ArrayList<Integer> list){
        Node current=root.right;
        Stack<Integer> st=new Stack<>();
        while(current!=null){
            if(!(current.right==null && current.left==null)){
                st.push(current.data);
            }
            if(current.right!=null){
                current=current.right;
            }
            else{
                current=current.left;
            }
        }
        while(!st.isEmpty()){
            list.add(st.pop());
        }
    }
    void addLeafNodes(Node root,ArrayList<Integer> list){
        if(root==null){
            return;
        }
        Node current=root;
        if(current.left==null && current.right==null){
            list.add(current.data);
            return;
        }
        addLeafNodes(current.left,list);
        addLeafNodes(current.right,list);
    }
    void addLeftBoundary(Node root,ArrayList<Integer> list){
        Node current=root.left;
        while(current!=null){
            //leaf nodes add nhi ho rhe hai ismai
            if(!(current.left==null && current.right==null)){
                list.add(current.data);
            }
            if(current.left!=null){
                current=current.left;
            }
            else{
                current=current.right;
            }
        }
    }
    ArrayList<Integer> boundaryTraversal(Node root) {
        // code here
        ArrayList<Integer> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        if(!(root.left == null && root.right == null)){
            list.add(root.data);
        }
        addLeftBoundary(root,list);
        addLeafNodes(root,list);
        addRightBoundary(root,list);
        return list;
    }
}
