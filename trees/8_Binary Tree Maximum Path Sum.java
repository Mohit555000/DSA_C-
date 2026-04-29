//https://leetcode.com/problems/binary-tree-maximum-path-sum/
//https://www.youtube.com/watch?v=WszrfSwMz58&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=17
class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(0, dfs(root.left));   // negative ignore
        int right = Math.max(0, dfs(root.right)); // negative ignore

        // current node ke through best path
        maxSum = Math.max(maxSum, root.val + left + right);

        // parent ko best single path return
        return root.val + Math.max(left, right);
    }
}

