/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        left = right = null;
    }
} */
//https://www.geeksforgeeks.org/problems/implementing-ceil-in-bst/1
class Solution {
    int findCeil(Node root, int x) {
        // code here
        if(root==null){  //if root itself is nul there is no tree and can tfind the ceil sos return -1
            return -1;
        }
        Node curr=root;
        int ans=-1;
        while(curr!=null){ //explore three tree till curr is not null
            if(curr.data==x){  //if i got curr==ceil we have found the perfect ceil so another number is as close to x then itself so break this otherwise we will stuck in infinte loop if we dont break it 
                ans=curr.data;
                break;
            }
            else if(curr.data>x){  //Current node is greater than x. It's a potential ceiling.
                ans=curr.data; //Save it as a candidate
                curr=curr.left; /// Move left to see if a smaller valid ceiling exists
            }
            else{  //Current node is less than x. Too small to be a ceiling.
                curr=curr.right; /// Move right to find larger values
            }
        }
        return ans;
        
    }
}


ask gemini for detailed explanation
