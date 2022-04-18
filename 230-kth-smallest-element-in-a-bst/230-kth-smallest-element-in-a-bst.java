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
    List<Integer> r = new ArrayList<>();
    
    public int kthSmallest(TreeNode root, int k) {
        
        if(root == null)
            return 0;
        dfs(root);
        Collections.sort(r);
        return r.get(k-1);
        
    }
    private void dfs(TreeNode curr){
        
        if(curr == null){
            return;
        }
        
        dfs(curr.left);
        r.add(curr.val);
        dfs(curr.right);
    }
}