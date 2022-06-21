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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
     
        List<List<Integer>> res = new ArrayList<>();
        
        if(root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        
        q.offer(root);
        
        int cnt = 0;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> arr = new ArrayList<>();
            while(size-- > 0){
                TreeNode curr = q.poll();
                arr.add(curr.val);
                
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
            if(cnt%2 == 0){
                res.add(arr);    
            }else{
                Collections.reverse(arr);
                res.add(arr);
            }
            cnt++;
        }
        return res;
    }
}