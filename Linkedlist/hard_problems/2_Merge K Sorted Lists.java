//https://www.youtube.com/watch?v=1zktEppsdig&list=PLgUwDviBIf0rAuz8tVcM0AymmhTRsfaLU&index=26
//https://leetcode.com/problems/merge-k-sorted-lists/description/

Brute force approach (using array)
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
    public ListNode convert(ArrayList<Integer> list){
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        for(int i=0;i<list.size();i++){
            temp.next=new ListNode(list.get(i));
            temp=temp.next;
        }
        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> list=new ArrayList<>();
        ListNode head=new ListNode(0);
        for(int i=0;i<lists.length;i++){
            ListNode temp=lists[i];
            while(temp!=null){
                list.add(temp.val);
                temp=temp.next;
            }
        }
        System.out.println(list);
        Collections.sort(list);
        head=convert(list);
        return head;
    }
}

Optimized Approach (withou using array, inplace)
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
    public ListNode merge2List(ListNode head1,ListNode head2){
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        ListNode dummy=new ListNode(0);
        ListNode temp=dummy;
        ListNode temp1=head1;
        ListNode temp2=head2;
        while(temp1!=null && temp2!=null){
            if(temp1.val<temp2.val){
                temp.next=temp1;
                temp1=temp1.next;
            }
            else{
                temp.next=temp2;
                temp2=temp2.next;
            }
            temp=temp.next;
        }
        if(temp1==null){
            temp.next=temp2;
        }
        else{
            temp.next=temp1;
        }
        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode head=lists[0];
        for(int i=1;i<lists.length;i++){
            head=merge2List(head,lists[i]);
        }
        return head;
    }
} 
