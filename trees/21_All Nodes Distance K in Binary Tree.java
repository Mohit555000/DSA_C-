//https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
//https://www.youtube.com/watch?v=1PMjfQl_UVQ

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //step 1 Create the parent map(mapping of child to its parent)
    public void buildMap(TreeNode node,TreeNode parent,Map<TreeNode,TreeNode> parentMap){
        if(node==null){
            return;
        }
        parentMap.put(node,parent);
        if(node.left!=null){
            parentMap.put(node.left,node);
        }
        buildMap(node.left,node,parentMap);
        if(node.right!=null){
            parentMap.put(node.right,node);
        }
        buildMap(node.right,node,parentMap);
    }
    //STep 2
    public void BFS(TreeNode target,int k,List<Integer> list,Map<TreeNode,TreeNode> parentMap){
        Queue<TreeNode> q=new ArrayDeque<>();
        Set<Integer> visited=new HashSet<>();
        q.add(target);
        visited.add(target.val);
        while(!q.isEmpty()){
            int n=q.size();
            if(k==0){
                break;
            }
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
            k--;
        }

        //Retriving the remaining elements from the queue
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            list.add(curr.val);
        }

    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parentMap=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        buildMap(root,null,parentMap);
        BFS(target,k,list,parentMap);
        return list;
    }
}
