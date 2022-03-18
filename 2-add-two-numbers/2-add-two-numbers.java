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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
     
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        int carry = 0;
        
        while(l1 != null && l2 != null){
            int sum = l1.val+l2.val+carry;
            prev.next = new ListNode(sum%10);
            prev = prev.next;
            carry = sum/10;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 != null){
            while(l1 != null){
                int tmp = l1.val+carry;
                prev.next = new ListNode(tmp%10);
                prev = prev.next;
                l1 = l1.next;
                carry = tmp/10;
            }
        }
        if(l2 != null){
            while(l2 != null){
                int tmp = l2.val+carry;
                prev.next = new ListNode(tmp%10);
                prev = prev.next;
                l2 = l2.next;
                carry = tmp/10;
            }
        }
        if(carry != 0){
            prev.next = new ListNode(carry);
            prev = prev.next;
        }
        prev.next = null;
        return dummy.next;
    }
}