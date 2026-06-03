this is similar to question 10. refer that first and then try to solve it
//https://www.youtube.com/watch?v=eccAKrmffh8&t=832s
//https://leetcode.com/problems/merge-k-sorted-lists/description/

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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0){
            return null;
        }
        // Define Min-Heap based on the node's value
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));
        // Step 1: Initialize the heap with the head of each non-empty linked list
        for(ListNode head:lists){
            if(head!=null){
                pq.add(head);
            }
        }
        // Dummy head to simplify building the final linked list
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        // Step 2: Stream through nodes "just-in-time"
        while(!pq.isEmpty()){
            ListNode current=pq.poll();
            tail.next=current;
            tail=tail.next;
            // Step 3: Advance the pointer for the list we just pulled from
            // If it has a next node, push it into the heap
            if(current.next!=null){
                pq.add(current.next);
            }
        }
        return dummy.next;
    }
}
