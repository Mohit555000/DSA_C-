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
    void IterativeInOrderTraversal(Node root){
        if(root!=null){
            Stack<Node> st=new Stack<>();
            Node current=root;
            while(current!=null || !st.isEmpty()){
                while(current!=null){
                    st.push(current);
                    current=current.left;
                }
                    current=st.pop();
                    System.out.println(current.data+" ");

                    current=current.right;
            }

        }   
    }
    public static void main(String[] args){
        System.out.println("Hello World!");

        BinaryTree tree=new BinaryTree();
        tree.root=new Node(1);
        tree.root.left=new Node(2);
        tree.root.right=new Node(3);
        tree.IterativeInOrderTraversal(tree.root);
    }
}
