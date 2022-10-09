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
    public boolean findTarget(TreeNode root, int k) {
        
        inorder(root);
        
        int left = 0;
        int right = r.size()-1;
        
        while(left < right){
            int tmp = r.get(left)+r.get(right);
            if(tmp == k){
                return true;
            }else if(tmp > k){
                right--;
            }else{
                left++;
            }
        }
        return false;
    }
    private void inorder(TreeNode curr){
        if(curr == null)
            return ;
        
        inorder(curr.left);
        r.add(curr.val);
        inorder(curr.right);
    }
}