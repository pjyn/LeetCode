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
    private int ans = 0;
    
    public int pseudoPalindromicPaths (TreeNode root) {
    
        int[] freq = new int[10];
        
        helper(root, freq);
        return ans;
    }
    
    private void helper(TreeNode root, int[] freq){
        if(root == null)
            return;
        
        freq[root.val]++;
        
        if(root.left == null && root.right == null){
            // this is a leaf node
            if(isPalindromicPermutation(freq)){
                ans++;
            }
        }
        helper(root.left, freq);
        helper(root.right, freq);
        
        freq[root.val]--;
        
    }
    private boolean isPalindromicPermutation(int[] freq){
        boolean addFreqFound = false;
        
        for(int el: freq){
            if(el%2 != 0){      //              [0, 0, 1, 2, ...]       addFreqFound = true->       
                if(addFreqFound){
                    return false;
                }else{
                    addFreqFound = true;
                }
            }
        }
        
        return true;
    }
}