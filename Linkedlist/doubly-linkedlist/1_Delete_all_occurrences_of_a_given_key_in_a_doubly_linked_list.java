//https://www.geeksforgeeks.org/problems/delete-all-occurrences-of-a-given-key-in-a-doubly-linked-list/1
//https://www.youtube.com/watch?v=Mh0NH_SD92k&list=PLgUwDviBIf0rAuz8tVcM0AymmhTRsfaLU&index=19
/* Structure of Doubly Linked List
class Node
{
    int data;
    Node next;
    Node prev;
}*/
class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        // code here
        if(head==null || head.next==null){
            return head;
        }
        Node temp=head;
        while(temp!=null){
            if(temp.data==x){
                if(temp==head){
                    head=head.next;
                }
                Node nextNode=temp.next;
                Node previousNode=temp.prev;
                if(nextNode!=null){
                    nextNode.prev=previousNode;
                }
                if(previousNode!=null){
                    previousNode.next=nextNode;
                }
                temp=nextNode;
            }
            else{
                temp=temp.next;
            }
        }
        return head;
    }
}