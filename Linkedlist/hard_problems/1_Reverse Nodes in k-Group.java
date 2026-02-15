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
//https://www.youtube.com/watch?v=lIar1skcQYI&list=PLgUwDviBIf0rAuz8tVcM0AymmhTRsfaLU&index=23
//https://leetcode.com/problems/reverse-nodes-in-k-group/
class Solution {
    public ListNode reverse(ListNode temp){
        ListNode previous = null;
        ListNode next = null;
        ListNode current = temp;

        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public ListNode findKthNode(ListNode temp, int k){
        k = k - 1;   // FIX: move k-1 steps
        while(k > 0 && temp != null){
            k--;
            temp = temp.next;
        }
        return temp;
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode temp = head;
        ListNode previousNode = null;   // FIX: move outside loop

        while(temp != null){

            ListNode kthNode = findKthNode(temp, k);

            if(kthNode == null){
                if(previousNode != null){          // FIX: null check
                    previousNode.next = temp;
                }
                break;
            }

            ListNode nextNode = kthNode.next;

            kthNode.next = null;

            ListNode newHead = reverse(temp);   // FIX: store reversed head

            if(temp == head){
                head = newHead;                 // FIX: use newHead
            }
            else{
                previousNode.next = newHead;    // FIX: connect using newHead
            }

            previousNode = temp;
            temp = nextNode;
        }

        return head;
    }
}
