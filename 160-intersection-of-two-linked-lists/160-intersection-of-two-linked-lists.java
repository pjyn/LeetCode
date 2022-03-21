/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode lA = headA;
        ListNode lB = headB;
        
        while(lA != null && lB != null){
            
            if(lA == lB){
                return lA;
            }
            lA = lA.next;
            lB = lB.next;
        }
        if(lA == null){
            lA = headB;
            while(lB != null){
                lB = lB.next;    
                lA = lA.next;
            }
            lB = headA;
            while(lA != lB){
                lA = lA.next;
                lB = lB.next;
            }
            return lA;
        }
        if(lB == null){
            lB = headA;
            while(lA != null){
                lA = lA.next;    
                lB = lB.next;
            }
            lA = headB;
            while(lA != lB){
                lA = lA.next;
                lB = lB.next;
            }
            return lA;
        }
        return null;
    }
}