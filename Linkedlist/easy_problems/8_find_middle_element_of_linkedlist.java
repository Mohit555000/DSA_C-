//https://leetcode.com/problems/middle-of-the-linked-list/description/?envType=problem-list-v2&envId=linked-list
class Solution {
    public int getCount(ListNode head){
        ListNode temp=head;
        int count=0;
        while(temp!=null){
            count=count+1;
            temp=temp.next;
        }
        return count;

    }
    public ListNode middleNode(ListNode head) {
        ListNode temp=head;
        int count=getCount(head);
        int middle=count/2;
        while(middle!=0){
            temp=temp.next;
            middle=middle-1;
        }
        return temp;
    }
}