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
    int cam;
    public int minCameraCover(TreeNode root) {
        return dfs(root) == 0 ? cam+1: cam;
    }
    /*
        2-> has camera
        1-> covered by Camera
        0-> not covered by camera
    */
    private int dfs(TreeNode node){
        if(node == null)
            return 1;
        
        int left = dfs(node.left);
        int right = dfs(node.right);
        
        if(left == 0 || right == 0){
            cam++;
            return 2;       // now they have camera
        }else if(left == 2 || right == 2){
            return 1;       // covered by camera
        }else{
            return 0;       // require camera.
        }

    }
}