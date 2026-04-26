import java.util.*;
class Node{
    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}

class BinaryTree{
        Node root;

    public BinaryTree(){
        root=null;
    }
        void iterativePreOrderTraversal(Node root){
        //phele root dalo
        //uske baad root ka right child
        //uske baad root ka left child
        //pre order kya root left right
        //iterative pre order ka trick use stack and reverse left and right mtlb add root then add right and then add left
        //root right left
        
        Stack<Node> st=new Stack<>();

        st.add(root);
        while(!st.isEmpty()){
            Node current=st.pop();
            System.out.print(current.data+" ");
            if(current.right!=null){
                st.add(current.right);
            }
            if(current.left!=null){
                st.add(current.left);
            }
        }
    }
    public static void main(String[] args){
                BinaryTree tree=new BinaryTree();

        //creating nodes

        tree.root=new Node(1);
        tree.root.left=new Node(2);
        tree.root.right=new Node(3);
        tree.root.left.left=new Node(4);
        tree.root.left.right=new Node(5);

        System.out.println("Iterative Pre Order Traversal");
        tree.iterativePreOrderTraversal(tree.root);
    }
}