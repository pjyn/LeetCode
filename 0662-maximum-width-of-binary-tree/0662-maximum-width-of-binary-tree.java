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
    HashMap<Integer, Integer> left_most_nodes = new HashMap<>();
    int max_width;
    
    public int widthOfBinaryTree(TreeNode root) {
        
        max_width = 0;
        get_widths(root, 0, 1); // pointer, depth, position
        return max_width;
    }
    private void get_widths(TreeNode curr, int depth, int position){
        
        if(curr == null){
            return ;
        }
        
        left_most_nodes.computeIfAbsent(depth, x-> position);
        
        /*
            Depth-wise:-
            0-> 1
            1-> 2
            2-> 4
        */
        
        max_width = Math.max(max_width, position-left_most_nodes.get(depth)+1);
            
        get_widths(curr.left, depth+1, position*2);
        get_widths(curr.right, depth+1, position*2+1);
    }
}