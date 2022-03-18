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
    List<List<Integer>> output_arr = new ArrayList<>();
    Stack<Integer> st = new Stack<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        if(root == null){
            return output_arr;
        }
        
        dfs(root, targetSum);
        return output_arr;
    }
    
    private void dfs(TreeNode curr, int targetSum){
        st.push(curr.val);

        if(curr.left == null && curr.right == null){
            if(targetSum == curr.val){
                output_arr.add(new ArrayList<Integer>(st));
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