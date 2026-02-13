/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next,prev;

    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/
//method 1 brute force approace
//https://www.geeksforgeeks.org/problems/find-pairs-with-given-sum-in-doubly-linked-list/1
//https://www.youtube.com/watch?v=YitR4dQsddE&list=PLgUwDviBIf0rAuz8tVcM0AymmhTRsfaLU&index=20
class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target,
                                                                      Node head) {
        // code here
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        
        Node temp1=head;
        
        while(temp1!=null){
            Node temp2=temp1.next;
            while((temp2!=null) && ((temp1.data+temp2.data)<=target)){
                if(temp1.data+temp2.data==target){
                    ArrayList<Integer> sum=new ArrayList<>();
                    sum.add(temp1.data);
                    sum.add(temp2.data);
                    ans.add(sum);
                }
                temp2=temp2.next;
            }
            temp1=temp1.next;
        }
        return ans;
    }
}


//method 2 optimized approach.
// Used two pointers because the list is sorted that's why

/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next,prev;

    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static Node findTail(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        return temp;
    }
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target,
                                                                      Node head) {
        // code here
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        Node left=head;
        Node right=findTail(head);
        while(left.data<right.data){
            if(left.data+right.data==target){
                ArrayList<Integer> sum=new ArrayList<>();
                sum.add(left.data);
                sum.add(right.data);
                ans.add(sum);
                left=left.next;
                right=right.prev;
            }
            else if(left.data+right.data>target){
                right=right.prev;
            }
            else{
                left=left.next;
            }
        }
        return ans;
    }
}
