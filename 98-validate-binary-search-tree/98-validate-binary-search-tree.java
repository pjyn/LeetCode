/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public boolean isValidBST(TreeNode root) {
        
        if(root == null){
            return true;
        }
        return rec(root, Long.MIN_VALUE, Long.MAX_VALUE);
        
    }
    private boolean rec(TreeNode curr, long min, long max){
        if(curr == null){
            return true;
        }
        
        if(curr.val >= max || curr.val <= min){
            return false;
        }
        return (rec(curr.left, min, curr.val) && rec(curr.right, curr.val, max));
    }
}