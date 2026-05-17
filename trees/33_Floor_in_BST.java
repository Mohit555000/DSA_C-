//https://www.geeksforgeeks.org/problems/closest-neighbor-in-bst/1
/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public int findMaxFork(Node root, int k) {
        // code here.
        if(root==null){
            return -1;
        }
        int ans=-1;
        Node curr=root;
        while(curr!=null){
            //curr.data is equal to k
            if(curr.data==k){// the greatest smaller element than k is k itself so if ifind k then i will return that
                ans=curr.data;
                break;
            }
            else if(k>curr.data){ // if my k i bigger than the current elemnt i cant go to left bcz i want smaller or equal not less than k so i i ill go to right and check for more 
                ans=curr.data;  //potential ans 
                curr=curr.right; //go more right and check
            }
            else{
                curr=curr.left; //if my current element is only greater i dont want that so i will go left and check 
            }
        }
        return ans;
    }
}


ask gemini for more details
