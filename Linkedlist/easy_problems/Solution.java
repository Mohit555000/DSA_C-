/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
//https://leetcode.com/problems/intersection-of-two-linked-lists/?envType=problem-list-v2&envId=linked-list
public class Solution {
    public int getLinkedListSize(ListNode node){
        int count=0;
        while(node!=null && node.next!=null){
            count=count+1;
            node=node.next;
        }
        return count;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA=getLinkedListSize(headA);
        int lenB=getLinkedListSize(headB);

        while(lenA>lenB){
            lenA--;
            headA=headA.next;
        }
        while(lenB>lenA){
            lenB--;
            headB=headB.next;
        }
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }
}