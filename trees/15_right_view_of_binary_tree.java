//https://leetcode.com/problems/binary-tree-right-side-view/description/
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

    public void rightSideViewUtil(TreeNode root, List<Integer> list, int level) {

        if (root == null) {
            return;
        }

        // First node encountered at this level
        if (level == list.size()) {
            list.add(root.val);
        }

        // Visit right first
        rightSideViewUtil(root.right, list, level + 1);

        // Then left
        rightSideViewUtil(root.left, list, level + 1);
    }

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        rightSideViewUtil(root, ans, 0);

        return ans;
    }
}


Dry Run

Tree:

       1
     /   \
    2     3
     \     \
      5     4

Traversal order:

1 -> 3 -> 4 -> 2 -> 5

Levels added:

Level 0 -> 1
Level 1 -> 3
Level 2 -> 4

Answer:

[1,3,4]
Time Complexity
O(n)
Space Complexity
O(h)

Where h is height of tree because of recursion stack.

  Let's dry run the code step by step in a simple way.

Tree:

       1
     /   \
    2     3
     \     \
      5     4

Code logic:

Go RIGHT first
Then LEFT
First node seen at every level is the answer

Initial:

ans = []

Call:

rightSideViewUtil(1, ans, 0)
Step 1

Current node:

1

Level:

0

Check:

if(level == list.size())

Currently:

0 == 0  -> true

So add:

ans = [1]

Now go RIGHT.

Step 2

Current node:

3

Level:

1

Check:

1 == 1 -> true

Add:

ans = [1, 3]

Go RIGHT.

Step 3

Current node:

4

Level:

2

Check:

2 == 2 -> true

Add:

ans = [1, 3, 4]

Go RIGHT → null

Return.

Go LEFT → null

Return.

Node 4 finished.

Back to node 3.

Now go LEFT of 3 → null

Return.

Node 3 finished.

Back to node 1.

Now go LEFT.

Step 4

Current node:

2

Level:

1

Check:

1 == 3 -> false

Why false?

Because:

ans = [1,3,4]
size = 3

This means level 1 was already filled by node 3.

So we DO NOT add 2.

Go RIGHT.

Step 5

Current node:

5

Level:

2

Check:

2 == 3 -> false

Level 2 already filled by node 4.

So DO NOT add 5.

Go RIGHT → null

Go LEFT → null

Return.

Traversal complete.

Final answer:

[1, 3, 4]
Main Important Observation

This line is the entire trick:

if(level == list.size())

Meaning:

"Have we already visited this level?"
NO → add node
YES → skip node

Since we visit RIGHT first, the first node at every level becomes the right-side visible node.

For left view


  For Left View, the logic remains the same.

The ONLY change is:

Instead of visiting:

root.right

first, you visit:

root.left

first.

Because now the first node encountered at every level should be the leftmost node.

Right View

Traversal order:

Root -> Right -> Left

Code:

rightSideViewUtil(root.right, list, level + 1);
rightSideViewUtil(root.left, list, level + 1);
Left View

Traversal order:

Root -> Left -> Right

Code:

leftViewUtil(root.left, list, level + 1);
leftViewUtil(root.right, list, level + 1);
Complete Left View Code
class Solution {

    public void leftViewUtil(TreeNode root, List<Integer> list, int level) {

        if (root == null) {
            return;
        }

        // First node of this level
        if (level == list.size()) {
            list.add(root.val);
        }

        // Visit left first
        leftViewUtil(root.left, list, level + 1);

        // Then right
        leftViewUtil(root.right, list, level + 1);
    }

    public List<Integer> leftSideView(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        leftViewUtil(root, ans, 0);

        return ans;
    }
}

Example:

       1
     /   \
    2     3
   / \     \
  4   5     6

Left View:

[1,2,4]

Right View:

[1,3,6]

So the entire trick is:

Whichever side you visit first,
that side becomes visible.
