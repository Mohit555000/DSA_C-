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
//https://leetcode.com/problems/add-two-numbers/description/?envType=problem-list-v2&envId=linked-list
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1=l1;
        ListNode temp2=l2;
        ListNode dummy=new ListNode();
        ListNode current=dummy;
        int carry=0;
        while((temp1!=null || temp2!=null)|| carry!=0){
            int sum=0;
            if(temp1!=null){
                sum=sum+temp1.val;
                temp1=temp1.next;
            }
            if(temp2!=null){
                sum=sum+temp2.val;
                temp2=temp2.next;
            }
            sum=sum+carry;
            carry=sum/10;

            ListNode ans=new ListNode(sum%10);
            current.next=ans;
            current=current.next;
        }
        return dummy.next;


    }
}