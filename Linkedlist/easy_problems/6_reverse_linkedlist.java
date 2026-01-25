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
//https://leetcode.com/problems/reverse-linked-list/?envType=problem-list-v2&envId=linked-list
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode previous=null;
        ListNode next=null;
        ListNode current=head;
        while(current!=null){
            next=current.next;
            current.next=previous;
            previous=current;
            current=next;
        }
        return previous;
    }
}