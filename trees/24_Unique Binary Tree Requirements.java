//https://www.geeksforgeeks.org/problems/unique-binary-tree-requirements/1
// User function Template for Java

class Solution {

    public static boolean isPossible(int a, int b) {
        // Code here
        if((a==2||b==2)&&(a!=b)){
            return true;
        }
        else{
            return false;
        }
    }
}
This question is a classic problem in data structures. To construct a unique binary tree (where the structure and placement of every node are exactly determined), you need a specific combination of traversal sequences.Here is the breakdown of why some pairs work and others don't.1. The "Golden Rule" of Unique TreesTo build a unique binary tree, you must have the Inorder traversal plus one other traversal (either Preorder or Postorder).Why is Inorder essential?Preorder/Postorder tells you which node is the Root.Inorder tells you which nodes belong to the Left Subtree and which belong to the Right Subtree by looking at what lies to the left and right of that Root.Without Inorder, you might know which node is the root, but you won't know if the remaining nodes are its left children, right children, or a mix of both.2. Analyzing the PairsPairCombinationCan build unique tree?Reason(1, 2)Preorder & InorderTruePreorder gives the root; Inorder splits the left/right subtrees.(2, 3)Inorder & PostorderTruePostorder gives the root; Inorder splits the left/right subtrees.(1, 3)Preorder & PostorderFalseYou can identify the root, but you cannot distinguish between a left-child and a right-child structure.The Preorder + Postorder ExceptionIf the tree is a Full Binary Tree (every node has either 0 or 2 children), then Preorder and Postorder can sometimes work. However, for a general binary tree, this pair is insufficient.3. How to answer the problemGiven the integer representations (1: Preorder, 2: Inorder, 3: Postorder):If the pair contains 2 (Inorder) and any other number (1 or 3), return true.If the pair is (1, 3) or any combination of the same number (e.g., 1 and 1), return false.Logic Summary:return (a == 2 || b == 2) && (a != b);
