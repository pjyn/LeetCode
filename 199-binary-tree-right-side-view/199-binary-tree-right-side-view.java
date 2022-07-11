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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> res = new ArrayList<>();
        rightView(root, 0, res);
        return res;
    }
    
    private void rightView(TreeNode curr, int depth, List<Integer> res){
        
        if(curr == null)
            return ;
        
        if(res.size() == depth)
            res.add(curr.val);
        
        rightView(curr.right, depth+1, res);
        rightView(curr.left, depth+1, res);
    }
}