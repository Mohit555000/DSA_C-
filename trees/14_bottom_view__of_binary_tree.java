//https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1

/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;

    }
}
*/

class Solution {
    public ArrayList<Integer> bottomView(Node root) {
        // code here
        Queue<pair> q=new ArrayDeque<>();
        Map<Integer,List<Integer>> map=new TreeMap<>();
        q.add(new pair(0,root));
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
                q.add(new pair(curr.hd-1,curr.node.left));
            }
            if(curr.node.right!=null){
                q.add(new pair(curr.hd+1,curr.node.right));
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(List<Integer> list:map.values()){
            if(list.size()==0){
                ans.add(list.get(0));
            }
            else{
                ans.add(list.get(list.size()-1));
            }
        }
        return ans;
    }
}

class pair{
    int hd;
    Node node;
    
    pair(int hd,Node node){
        this.hd=hd;
        this.node=node;
    }
}


first solve vertical order traversal of binary tree
then solve top view of binary tree and then solve this question.
sab same hai bs if list (map ki values :(list of integer)) mai bs ek he element hai toh directly final arraylist mai voh add kar na hai 
  if more than 1 element is present then always add the last element of the list.
