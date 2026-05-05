//https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1

/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
class Solution {
    public ArrayList<Integer> topView(Node root) {
        // code here
        Queue<pair> q=new ArrayDeque<>();
        q.add(new pair(root,0));
        Map<Integer,List<Integer>> map=new TreeMap<>();
        while(!q.isEmpty()){
            pair curr=q.poll();
            if(map.containsKey(curr.hd)){
                map.get(curr.hd).add(curr.node.data);
            }
            else{
                List<Integer> temp=new ArrayList<>();
                temp.add(curr.node.data);
                map.put(curr.hd,temp);
            }
            if(curr.node.left!=null){
                q.add(new pair(curr.node.left,curr.hd-1));
            }
            if(curr.node.right!=null){
                q.add(new pair(curr.node.right,curr.hd+1));
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(List<Integer> list:map.values()){
            if(!list.isEmpty()){
                ans.add(list.get(0));
            }
        }
        return ans;
        
    }
}

class pair{
    Node node;
    int hd;
    
    pair(Node node,int hd){
        this.node=node;
        this.hd=hd;
    }
}


first solve vertical traversal of binary tree sum then solve this.
  almost similar hai bs humko map mai jo value has (which is list of integer usmai se humko bs first element fetch kar na hai )
