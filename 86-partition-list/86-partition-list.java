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
    public ListNode partition(ListNode head, int x) {
        
        ListNode before_head = new ListNode(-1);
        ListNode before = before_head;
        ListNode after_head = new ListNode(-1);
        ListNode after = after_head;
        ListNode curr = head;
        
        while(curr != null){
            
            if(curr.val < x){
                before.next = curr;
                before = before.next;
            }else{
                after.next = curr;
                after = after.next;
            }
            curr = curr.next;
        }
        
        after.next = null;
        before.next = after_head.next;
        
        return before_head.next;
    }
}