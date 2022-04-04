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
    public ListNode swapNodes(ListNode head, int k) {
        
        ListNode dummy = new ListNode(-1);
        ListNode curr = head;
        ListNode prev = dummy;
        
        int length = 0;
        int cnt = 0;
        List<Integer> arr = new ArrayList<>();
        
        while(curr != null){
            arr.add(curr.val);
            curr = curr.next;
            length++;
        }
        System.out.println(length);
        // [1, 2, 3, 4, 5]
        
        curr = head;
        cnt = 1;
        for(int ele: arr){
            if(cnt == k){
                prev.next = new ListNode(arr.get(length-k));
                prev = prev.next;
                
            }else if(cnt == length-k+1){
                prev.next = new ListNode(arr.get(k-1));
                prev = prev.next;
            }else{
                prev.next = new ListNode(ele);
                prev = prev.next;
            }
            cnt++;
        }
        return dummy.next;
    }
}