//method 1
//question - https://leetcode.com/problems/odd-even-linked-list/?envType=problem-list-v2&envId=linked-list
//Explanation - https://www.youtube.com/watch?v=qf6qp7GzD5Q
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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ArrayList<Integer> list=new ArrayList<>();
        ListNode odd_temp=head;
        ListNode even_temp=head.next;
        ListNode temp=head;
        int i=0;
        while(odd_temp!=null && odd_temp.next!=null){
            list.add(odd_temp.val);
            odd_temp=odd_temp.next.next;
        }
        if(odd_temp!=null){
            list.add(odd_temp.val);
        }
        while(even_temp!=null && even_temp.next!=null){
            list.add(even_temp.val);
            even_temp=even_temp.next.next;
        }
        if(even_temp!=null){
            list.add(even_temp.val);
        }
        System.out.println(list);
        while(temp!=null){
            temp.val=list.get(i);
            i++;
            temp=temp.next;
        }

        return head;

    }
}


//method 2
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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode odd_head=head;
        ListNode even_head=head.next;
        ListNode even=head.next;

        while(even_head!=null && even_head.next!=null){
            odd_head.next=odd_head.next.next;
            even_head.next=even_head.next.next;

            odd_head=odd_head.next;
            even_head=even_head.next;
        }
        odd_head.next=even;
        return head;
    }
}