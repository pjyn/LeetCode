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
    Stack<Integer> st;
    boolean isValid;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        if(root == null)
            return false;
        
        st = new Stack<>();
        isValid = false;
        dfs(root, targetSum);
        return isValid;
    }
    
    private void dfs(TreeNode curr, int targetSum){
        st.push(curr.val);
        
        if(curr.left == null && curr.right == null){
            if(targetSum == curr.val){
                isValid = true;
                return ;
            }
        }
        
        if(curr.left != null){
            dfs(curr.left, targetSum - curr.val);
        }
        if(curr.right != null){
            dfs(curr.right, targetSum - curr.val);
        }
        
        st.pop();
    }
}