//https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/description/

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
    public void parentMapping(TreeNode node,TreeNode parent,Map<TreeNode, TreeNode> parentMap){
        if(node==null){
            return;
        }
        parentMap.put(node,parent);
        if(node.left!=null){
            parentMap.put(node.left,node);
        }
        parentMapping(node.left,node,parentMap);
        if(node.right!=null){
            parentMap.put(node.right,node);
        }
        parentMapping(node.right,node,parentMap);
    }
    public TreeNode findStartNode(TreeNode root,int start){
        
        if(root==null){
            return null;
        }
        if(root.val==start){
            return root;
        }
        if(root.left!=null){
            TreeNode start_node=findStartNode(root.left,start);
            if(start_node!=null){
                return start_node;
            }
        }
        if(root.right!=null){
            TreeNode start_node=findStartNode(root.right,start);
            if(start_node!=null){
                return start_node;
            }
        }
        return null;
    }
    public int timeCalculation(TreeNode start,Map<TreeNode, TreeNode> parentMap){
        Set<Integer> visited=new HashSet<>();
        Queue<TreeNode> q=new ArrayDeque<>();
        int count=0;
        q.add(start);
        visited.add(start.val);

        while(!q.isEmpty()){
            int n=q.size();
            while(n!=0){
                TreeNode curr=q.poll();
                //Left Child
                if(curr.left!=null && !visited.contains(curr.left.val)){
                    q.add(curr.left);
                    visited.add(curr.left.val);
                }
                //Right Child
                if(curr.right!=null && !visited.contains(curr.right.val)){
                    q.add(curr.right);
                    visited.add(curr.right.val);
                }
                //Parent
                TreeNode parent=parentMap.get(curr);
                if(parent!=null && !visited.contains(parent.val)){
                    q.add(parent);
                    visited.add(parent.val);
                }
                n--;
            }
            count++;
        }
        return count;
    }
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parentMap=new HashMap<>();
        parentMapping(root,null,parentMap);
        TreeNode startNode=findStartNode(root,start);
        int amount=timeCalculation(startNode,parentMap);
        return amount-1;
    }
}


first solve problem 21 refere that one and it will become easy to solve
