import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                // No left child, visit node and move right
                result.add(curr.val);
                curr = curr.right;
            } else {
                // Find the inorder predecessor
                TreeNode prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    // Create temporary bridge
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    // Bridge already exists, meaning left subtree is done
                    prev.right = null; // Destroy bridge
                    result.add(curr.val); // Visit node
                    curr = curr.right; // Move right
                }
            }
        }
        return result;
    }
}
