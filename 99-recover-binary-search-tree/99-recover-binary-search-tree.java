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
    private TreeNode prev = null;
    private TreeNode one = null;
    private TreeNode two = null;
    
    public void recoverTree(TreeNode root) {
        inorder(root);
        int tmp = one.val;
        one.val = two.val;
        two.val = tmp;
    }
    
    private void inorder(TreeNode curr){
        if(curr == null)
            return ;
        
        inorder(curr.left);
        if(prev != null && prev.val > curr.val){
            if(one == null){
                one = prev;
            }
            two = curr;
        }
        prev = curr;
        inorder(curr.right);
    }
}