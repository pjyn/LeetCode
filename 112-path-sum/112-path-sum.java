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
    Stack<Integer> st = new Stack<>();
    boolean ans = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        if(root == null)
            return false;
        
        dfs(root, targetSum);
        return ans;
    }
    private void dfs(TreeNode curr, int target){
        st.push(curr.val);
        
        if(curr.left == null && curr.right == null){
            if(curr.val == target){
                ans = true;
                return ;
            }
        }
        
        if(curr.left != null){
            dfs(curr.left, target-curr.val);
        }
        if(curr.right != null){
            dfs(curr.right, target-curr.val);
        }
        st.pop();
    }
}