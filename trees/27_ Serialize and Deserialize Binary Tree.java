//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
//https://www.youtube.com/watch?v=-YbXySKJsX8&list=PLkjdNRgDmcc0Pom5erUBU4ZayeU9AyRRu&index=36
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null){
            return null;
        }
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(curr==null){
                sb.append("null,");
            }
            else{
                
                    sb.append(curr.val).append(",");
                    q.add(curr.left);
                    q.add(curr.right);
                
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || "null".equals(data)){
            return null;
        }

        String[] nodes=data.split(",");
        Queue<TreeNode> q=new ArrayDeque<>();
        TreeNode root=new TreeNode(Integer.parseInt(nodes[0]));
        q.add(root);
        int i=1;
        while(!q.isEmpty() && i<nodes.length){
            TreeNode parent=q.poll();
            //left child
            if(!nodes[i].equals("null")){
                TreeNode leftChild=new TreeNode(Integer.parseInt(nodes[i]));
                parent.left=leftChild;
                q.add(leftChild);
            }
            i++;
            //Right child
            if(i<nodes.length && !nodes[i].equals("null")){
                TreeNode rightChild=new TreeNode(Integer.parseInt(nodes[i]));
                parent.right=rightChild;
                q.add(rightChild);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
