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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(head == null || k == 1){
            return head;
        }
        
        ListNode dummy = new ListNode(-1, head);
        
        int total_length = 0;
        
        ListNode curr = head;
        
        while(curr != null){
            
            total_length++;
            curr = curr.next;
        }
        
        curr = head;
        ListNode next = null;
        ListNode prev = dummy;
        
        while(total_length >= k){
            
            curr = prev.next;
            next = curr.next;
            
            for(int i=1; i<k; i++){
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }
            
            prev = curr;
            total_length = total_length-k;
        }
        return dummy.next;
    }
}