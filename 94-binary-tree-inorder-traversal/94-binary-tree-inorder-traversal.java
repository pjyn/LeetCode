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
    List<Integer> res;
    public List<Integer> inorderTraversal(TreeNode root) {
        
        res = new ArrayList<>();
        rec(root);
        return res;
    }
    private void rec(TreeNode curr){
        if(curr == null)
            return ;
        
        rec(curr.left);
        res.add(curr.val);
        rec(curr.right);
    }
}