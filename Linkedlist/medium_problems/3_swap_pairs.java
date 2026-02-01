//https://leetcode.com/problems/swap-nodes-in-pairs/description/?envType=problem-list-v2&envId=linked-list
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
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode first=head;
        ListNode second=first.next;



        first.next=swapPairs(second.next);
        second.next=first;
        return second;
    }
}

// Example:
// Main sirf chhota case consider kar raha hoon:

// 1 → 2 → null

// Yahan:
// first = 1
// second = 2

// first = 1
// second = 2
// Sabse pehle base condition check hoti hai —
// agar head == null ya head.next == null ho, toh head hi return kar dete hain,
// kyunki ya toh list empty hoti hai ya sirf ek element hota hai.
// Is case me base condition false hai, kyunki do nodes present hain.

// Phir hum yeh line execute karte hain:

// first.next = swapPairs(second.next)

// Yahan second.next already null hai,
// isliye swapPairs(null) base case hit karta hai aur null return hota hai.
// Iska matlab first.next ab null ko point kar raha hai.

// Ab structure kuch aisa ho jaata hai:
// 1 → null
// 2 → null

// Humne first ko kahin move nahi kiya hai,
// isliye uska reference abhi bhi safe hai aur lost nahi hua.

// Ab actual swap hota hai:
// second.next = first


// Iske baad list ban jaati hai:
// 2 → 1 → null

// Last me hum second return karte hain,
// kyunki swap hone ke baad second hi naya head ban chuka hota hai.
