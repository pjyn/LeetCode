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
    public TreeNode pruneTree(TreeNode root) {
        if(root == null){
            return null;
        }
        
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if(canBeDeleted(root)){
            return null;
        }
        return root;
    }
    private boolean canBeDeleted(TreeNode node){
        if(node.val == 0 && node.left == null && node.right == null)
            return true;
        return false;
    }
}