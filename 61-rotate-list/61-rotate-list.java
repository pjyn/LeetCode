/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 
    k%length = 2%5 = 2
    
    5->1->2->3->4
    4->5->1->2->3
    3->4->5->1->2
    2->3->4->5->1
    1->2->3->4->5
    
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        
        if(k == 0 || head == null){
            return head;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        ListNode curr = head;
        int len = 0;
        
        while(curr != null){
            len++;
            curr = curr.next;
        }
        k = k%len;  // 2%5     
        
        if(k%len == 0){
            return head;
        }
        curr = head;
        for(int i=0; i<len-k-1; i++){
            curr = curr.next;
        }
        ListNode newHead = curr.next;
        curr.next = null;
        ListNode tmpStart = newHead;
        while(k-- > 1){
            tmpStart = tmpStart.next;
        }
        tmpStart.next = head;
        
        return newHead;
    }
}