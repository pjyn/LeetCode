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
    List<List<Integer>> output = new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        if(root == null){
            return output;
        }
        dfs(root, targetSum);
        return output;
    }
    
    private void dfs(TreeNode curr, int sum){
        st.push(curr.val);
            
        if(curr.left == null && curr.right == null){
            if(sum == curr.val){
                output.add(new ArrayList<Integer>(st));
            }
        }
        if(curr.left != null){
            dfs(curr.left, sum-curr.val);
        }
        if(curr.right != null){
            dfs(curr.right, sum-curr.val);
        }
        st.pop();
    }
}