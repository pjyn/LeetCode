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
    public int goodNodes(TreeNode root) {
        
        return dfs(root, root.val);
    }
    
    private int dfs(TreeNode curr, int maxVal){
        
        if(curr == null)
            return 0;
        
        int res = curr.val >= maxVal ? 1 : 0;
        maxVal = Math.max(maxVal, curr.val);
        res += dfs(curr.left, maxVal);
        res += dfs(curr.right, maxVal);
        
        return res;
    }
}