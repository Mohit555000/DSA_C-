/*
class Node {
    int data;
    Node left, right;
    Node(int item){
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    public ArrayList<Integer> inOrder(Node root) {
        // code here
        ArrayList<Integer> list=new ArrayList<>();
        Node current=root;
        while(current!=null){
            //left child does not exist
            if(current.left==null){
                list.add(current.data);
                current=current.right;
            }
            //left child exist
            else{
                Node predecessor=current.left;
                
                while(predecessor.right!=null){
                    if(predecessor.right==current){
                        break;
                    }
                    predecessor = predecessor.right;
                }
                if(predecessor.right==null){
                    predecessor.right=current;
                    current=current.left;
                }
                else{
                    predecessor.right=null;
                    list.add(current.data);
                    current=current.right;
                }
            }
        }
        return list;
    }
}

https://www.geeksforgeeks.org/problems/inorder-traversal/1

https://chatgpt.com/c/6a072b60-b198-8321-8da9-2eac9de41bbc


ask chagpt ki what hi moris traversal and what problem does it solve didnt understood much from youtube videos.
