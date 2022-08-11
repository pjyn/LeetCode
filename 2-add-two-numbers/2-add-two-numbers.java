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
        ListNode head_ref = dummy;
        
        int carry = 0;
        
        while(l1 != null && l2 != null){
            int tmp = l1.val + l2.val + carry;
            
            
            dummy.next = new ListNode(tmp%10);
            dummy = dummy.next;
            l1 = l1.next;
            l2 = l2.next;
            carry = tmp/10;
        }
        if(l1 != null){
            while(l1 != null){
                int sum = l1.val + carry;
                dummy.next = new ListNode(sum%10);
                dummy = dummy.next;
                l1 = l1.next;
                carry = sum/10;
            }
        }
        if(l2 != null){
            while(l2 != null){
                int sum = l2.val + carry;
                dummy.next = new ListNode(sum%10);
                dummy = dummy.next;
                l2 = l2.next;
                carry = sum/10;
            }
        }
        if(carry != 0){
            dummy.next = new ListNode(carry);
            dummy = dummy.next;
            dummy.next = null;
        }
        return head_ref.next;
    }
}