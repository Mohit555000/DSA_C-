//https://leetcode.com/problems/delete-node-in-a-bst/description/
//https://www.youtube.com/watch?v=kouxiP_H5WE&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=44

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode findMin(TreeNode node){
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        //Base Case
        if(root==null){
            return null;
        }
        //Stage 1 Find the node and remove it
        if(key<root.val){
            /// The key is smaller, so it's in the left subtree
            root.left=deleteNode(root.left,key);
        }
        else if(key>root.val){
            // /The key is larger, so it's in the right subtree
            root.right=deleteNode(root.right,key);
        }
        // STAGE 2: We found the node to delete!
        else{
            // Case 1 & 2: Node has 0 children (leaf) or only 1 child
            if(root.left==null){
                return root.right; // If no left child, return right child to patch the parent pointer
            }
            else if(root.right==null){
                return root.left; // If no right child, return left child to patch the parent pointer
            }
            // Case 3: Node has 2 children
            // Find the inorder successor (smallest value in the right subtree)
            else{
                TreeNode successor=findMin(root.right);
                // Replace the target node's value with the successor's value
                root.val = successor.val;
                root.right = deleteNode(root.right, successor.val);
            }
            
        }
        return root;
    }
}

The Setup
Imagine we have the following BST and we want to delete the node with key = 3:

Plaintext
       5
      / \
     3   6
    / \   \
   2   4   7
We call our function: deleteNode(root, 3), where root is the node 5.

Step-by-Step Dry Run
1. First Call: deleteNode(Node(5), 3)
Check: Is root == null? No.

Compare: Is key (3) < root.val (5)? Yes!

Action: The code moves to the left subtree:

Java
root.left = deleteNode(root.left, 3); // root.left is Node(3)
The execution pauses here while we wait for the result of deleteNode(Node(3), 3).

2. Second Call: deleteNode(Node(3), 3)
Check: Is root == null? No.

Compare: Is key (3) < root.val (3)? No. Is key (3) > root.val (3)? No.

Match Found: They are equal! We have found the node to delete (Node(3)).

Evaluate Child Cases:

Is root.left == null? No, it points to Node(2).

Is root.right == null? No, it points to Node(4).

Result: This falls under Case 3 (Two Children).

3. Handling the 2-Children Case inside Node(3)
Now, the code executes the Case 3 logic to replace the node rather than destroying the structure:

Find the successor:

Java
   TreeNode successor = findMin(root.right); // root.right is Node(4)
The findMin helper goes to Node(4). Since Node(4) has no left child, Node(4) itself is returned as the minimum. So, successor.val = 4.

Copy the value:

Java
   root.val = successor.val; 
The value of our current node changes from 3 to 4.
Our tree temporarily looks like this (with a duplicate 4):

Plaintext
          5
         / \
        4   6
       / \   \
      2   4   7
Delete the duplicate:
Now we need to clear out the old successor node from the right subtree:

Java
   root.right = deleteNode(root.right, 4); // root.right is Node(4)
The execution pauses again for this new sub-call.

4. Third Call: deleteNode(Node(4), 4)
Check: We found a match (key == root.val).

Evaluate Child Cases:

Is root.left == null? Yes! Node(4) has no left child.

Action: Because its left child is null, it triggers this block:

Java
  if (root.left == null) {
      return root.right; 
  }
Since root.right for this node is also null, it returns null.

Unwinding the Stack (The Return Journey)
Now that the recursive calls are finishing, they hand their results back up the chain:

Back to the Second Call (Node(4)—formerly Node(3)):
It receives null from the third call and assigns it:

Java
  root.right = null;
Then it returns itself (Node(4)) back up to its caller.

Back to the First Call (Node(5)):
It receives Node(4) from the second call and assigns it to its left arm:

Java
root.left = Node(4);
Finally, Node(5) returns itself to the original user.

Final Tree Structure
The pointer from 5's left arm now hooks perfectly into 4, and 4's right arm was safely set to null. The duplicate is gone, and the BST property is completely preserved:

Plaintext
       5
      / \
     4   6
    /     \
   2       7
