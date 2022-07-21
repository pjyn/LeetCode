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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        ListNode curr = head;
        ListNode prev = null;
        
        while(left > 1){
            prev = curr;
            curr = curr.next;
            left--;
            right--;
        }
        ListNode connection = prev;     // 1
        ListNode tail = curr;       // 2
        
        while(right > 0){
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
            right--;
        }
        if(connection != null){
            connection.next = prev;
        }else{
            head = prev;
        }
        tail.next = curr;
        return head;
    }
}