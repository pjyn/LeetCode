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
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        
        dfs(root);
        return res;
    }
    
    private void dfs(TreeNode curr){
        if(curr == null){
            return ;
        }
        
        dfs(curr.left);
        res.add(curr.val);
        dfs(curr.right);
    }
}