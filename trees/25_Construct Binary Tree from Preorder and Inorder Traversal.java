//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
//https://www.youtube.com/watch?v=33b1M980cCA
class Solution {
    // Global variable: Isse saari recursive calls ek hi counter share karengi
    int preIndex = 0; 

    public int search(int[] inorder, int left, int right, int val) {
        // Sirf current boundary [left, right] mein search karein
        for (int i = left; i <= right; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode helper(int[] preorder, int[] inorder, int left, int right) {
        // Base Case
        if (left > right) {
            return null;
        }

        // 1. Root banao current preIndex se
        TreeNode root = new TreeNode(preorder[preIndex]);
        
        // 2. Inorder mein index dhundo
        int index = search(inorder, left, right, preorder[preIndex]);
        
        // 3. preIndex ko badhao taaki AGLI call naya element uthaye
        preIndex++;

        // 4. Left aur Right subtrees build karo
        root.left = helper(preorder, inorder, left, index - 1);
        root.right = helper(preorder, inorder, index + 1, right);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0; // Reset for multiple test cases
        return helper(preorder, inorder, 0, inorder.length - 1);
    }
}
