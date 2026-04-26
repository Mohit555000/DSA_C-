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
    void inordertraversal(Node root){
        if(root!=null){
            inordertraversal(root.left);
            System.out.print(root.data+" ");
            inordertraversal(root.right);
        }
    }
    void preordertraversal(Node root){
        if(root!=null){
            System.out.print(root.data+" ");
            preordertraversal(root.left);
            preordertraversal(root.right);
        }
    }
    void postordertraversal(Node root){
        if(root!=null){
            postordertraversal(root.left);
            postordertraversal(root.right);
            System.out.print(root.data+" ");
        }
    }
    void levelOrderTraversal(Node root){
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node current=queue.poll();
            System.out.print(current.data+" ");

            if(current.left!=null){
                queue.add(current.left);
            }
            if(current.right!=null){
                queue.add(current.right);
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

        System.out.println("Binary tree created");

        System.out.println("Inorder Traversal");
        tree.inordertraversal(tree.root);
        System.out.println();
        System.out.println("preordertraversal Traversal");
        tree.preordertraversal(tree.root);
        System.out.println();
        System.out.println("postordertraversal Traversal");
        tree.postordertraversal(tree.root);

        System.out.println();
        System.out.println("levelOrderTraversal Traversal");
        tree.levelOrderTraversal(tree.root);
    }
}