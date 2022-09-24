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
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        res = new ArrayList<>();
        if(root == null)
            return res;
        dfs(root, targetSum);
        return res;
    }
    
    private void dfs(TreeNode curr, int targetSum){
        
        st.push(curr.val);
        
        if(curr.left == null && curr.right == null){
            if(targetSum == curr.val){
                res.add(new ArrayList<>(st));
            }
        }
        
        if(curr.left != null){
            dfs(curr.left, targetSum-curr.val);
        }
        if(curr.right != null){
            dfs(curr.right, targetSum-curr.val);
        }
        st.pop();
    }
}