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
    List<TreeNode> nodes = new ArrayList<>();
    public TreeNode increasingBST(TreeNode root) {
        
        if(root == null)
            return null;
        
        inorder(root);
        
        for(int i=0; i<nodes.size()-1; i++){
            nodes.get(i).right = nodes.get(i+1);
            nodes.get(i).left = null;
        }
        nodes.get(nodes.size()-1).left = null;
        nodes.get(nodes.size()-1).right = null;
        
        return nodes.get(0);
    }
    
    private void inorder(TreeNode curr){
        
        if(curr == null){
            return ;
        }
        
        inorder(curr.left);
        nodes.add(curr);
        inorder(curr.right);
    }
}