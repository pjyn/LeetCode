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
     
        int count = 0;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode tmp = dummy;
        
        // count no of nodes
        while(tmp.next != null){
            tmp = tmp.next;
            count++;
        }
        
        // reverse in k-groups
        
        tmp = dummy;
        while(tmp.next != null){
            if(count < k)
                break;
            
            int nodes = k-1;
            ListNode tmpfirst = tmp.next;
            ListNode prev = tmp.next;
            ListNode curr = prev.next;
            
            while(nodes--> 0){
                ListNode nxt = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nxt;
            }
            count -= k;
            tmp.next = prev;        // joined dummy to reversed list
            tmpfirst.next = curr;    // join them to next group
            tmp = tmpfirst;
        }
        return dummy.next;
    }
}