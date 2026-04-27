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
    void iterativePostOrderTraversal(Node root){
        List<Integer> list=new ArrayList<>();
        Stack<Node> st1=new Stack<>();
        Stack<Node> st2=new Stack<>();

        st1.push(root);
        while(!st1.isEmpty()){
            root=st1.pop();
            st2.add(root);
            if(root.left!=null) st1.add(root.left);
            if(root.right!=null) st1.add(root.right);
        }
        while(!st2.isEmpty()){
            System.out.println(st2.pop().data+" ");
        }
        

    }
    public static void main(String[] args){
        System.out.println("Hello World!");

        BinaryTree tree=new BinaryTree();
        tree.root=new Node(1);
        tree.root.left=new Node(2);
        tree.root.right=new Node(3);
        tree.iterativePostOrderTraversal(tree.root);
    }
}
