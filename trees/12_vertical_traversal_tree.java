//https://www.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1
//https://www.youtube.com/watch?v=h7xALnzllec
/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
        // code here
        Queue<Pair> q=new ArrayDeque<>();
        Map<Integer,List<Integer>> map=new TreeMap<>();
        q.add(new Pair(0,root));
        while(!q.isEmpty()){
            Pair curr=q.poll();
            if(map.containsKey(curr.hd)){
                map.get(curr.hd).add(curr.node.data);
            }
            else{
                List<Integer> temp=new ArrayList<>();
                temp.add(curr.node.data);
                map.put(curr.hd,temp);
            }
            if(curr.node.left!=null){
                q.add(new Pair(curr.hd-1,curr.node.left));
            }
            if(curr.node.right!=null){
                q.add(new Pair(curr.hd+1,curr.node.right));
            }
        }
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
    ans.add(new ArrayList<>(entry.getValue()));
}
        return ans;
    }
}

class Pair{
    int hd;
    Node node;
    
    Pair(int hd,Node node){
        this.hd=hd;
        this.node=node;
    }
}
