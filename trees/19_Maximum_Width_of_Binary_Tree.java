//https://leetcode.com/problems/maximum-width-of-binary-tree/description/
//https://www.youtube.com/watch?v=rhz-csskg_A&t=1004s
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        // FIX 1 & 2: Use Deque interface and clean up non-generic Pair
        Deque<Pair> q = new ArrayDeque<>();
        
        // FIX 3: Instantiate the Pair object
        q.add(new Pair(root, 0));
        int maxWidth = 0;

        while (!q.isEmpty()) {
            int currentLevelSize = q.size();
            int startIndex = q.peekFirst().index;
            int endIndex = q.peekLast().index;

            maxWidth = Math.max(maxWidth, endIndex - startIndex + 1);
            
            // FIX 4: Removed parentheses from currentLevelSize
            for (int i = 0; i < currentLevelSize; i++) {
                Pair curr = q.poll();
                
                // FIX 5: Properly declared variable 'node'
                TreeNode node = curr.root;
                int index = curr.index;

                // FIX 6 & 7: Used 'index' instead of 'i', and fixed 'nore' typo
                if (node.left != null) {
                    q.add(new Pair(node.left, 2 * index+1));
                }
                if (node.right != null) {
                    q.add(new Pair(node.right, 2 * index + 2));
                }
            }
        }
        return maxWidth;
    }
}

class Pair {
    TreeNode root;
    int index;

    Pair(TreeNode root, int index) {
        this.root = root;
        this.index = index;
    }
}
