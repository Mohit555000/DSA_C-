//https://leetcode.com/problems/rotate-list/description/?envType=problem-list-v2&envId=linked-list

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int findSize(ListNode temp){
        int count=0;
        while(temp!=null){
            count=count+1;
            temp=temp.next;
        }
        return count;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode temp=head;
        int listSize=findSize(temp);
        k = k % listSize;    //since the length of the k can be large so we make module of it with the size of linkeldist to make it in range.
        int newTail=listSize-k;
        ListNode tail=head;
        ListNode current=head;

        while(tail.next!=null){
            tail=tail.next;
        }
        tail.next=head;
        for(int i=1;i<newTail;i++){
            current=current.next;
        }
        head=current.next;
        current.next=null;
        return head;
    }
}

//https://www.youtube.com/watch?v=uT7YI7XbTY8




