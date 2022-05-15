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
    public int deepestLeavesSum(TreeNode root) {
     
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        int level_sum = 0;
        
        while(!q.isEmpty()){
            level_sum = 0;
            
            int size = q.size();
            while(size-- > 0){
                TreeNode head = q.poll();
                level_sum += head.val;
                if(head.left != null)
                    q.offer(head.left);
                if(head.right != null)
                    q.offer(head.right);
            }
        }
        return level_sum;
    }
}