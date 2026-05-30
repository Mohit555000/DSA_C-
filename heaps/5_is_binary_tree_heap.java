//https://www.geeksforgeeks.org/problems/is-binary-tree-heap/1
//https://www.youtube.com/watch?v=_9F2VgZcvdw&list=PLWlla5Y-1FqyOqTat11CmcQp1nl079d0W&index=2
/*
class Node {
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    public boolean heap(Node root){
        //three cases exist 1) it is aleaf node 2) only left child 3) both the child
        //case 1) leaf node
        if(root.left==null && root.right==null){
            return true;
        }
        //case 2) only left child exist
        else if(root.right==null){
            if(root.data>root.left.data){
                return true;
            }
            else{
                return false;
            }
        }
        //case 3 bot child exist
        else{
            boolean left=heap(root.left);
            boolean right=heap(root.right);
            if((left&&right)&&(root.data>root.left.data&&root.data>root.right.data)){
                return true;
            }
            else{
                return false;
            }
        }
    }
    
    public int totalNodes(Node root){
        if(root==null){
            return 0;
        }
        return 1 +totalNodes(root.left)+totalNodes(root.right);
    }
    
    public boolean cbt(Node currentNode,int currentNodeIndex,int totalNumberOfNodes){
        if(currentNode==null){
            return true;
        }
        if(currentNodeIndex>=totalNumberOfNodes){ // Note: Fixed the bounds operator to >= so it runs correctly
            return false;
        }
        else{
            // Note: Changed from isHeap back to cbt to avoid template conflict
            boolean leftSubTree=cbt(currentNode.left,(2*currentNodeIndex)+1,totalNumberOfNodes);
            boolean rightSubTree=cbt(currentNode.right,(2*currentNodeIndex)+2,totalNumberOfNodes);
            
            return leftSubTree&&rightSubTree;
        }
    }
    
    // Core wrapper method where your driver code now lives safely inside
    public boolean isHeap(Node tree) {
        if(tree==null){
            return true;
        }
        
        int totalNumberOfNodes=totalNodes(tree);
        
        if(cbt(tree,0,totalNumberOfNodes)&&heap(tree)){
            return true;
        }
        else{
            return false;
        }
    }
}
