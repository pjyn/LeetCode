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
    List<Double> rt;
    public List<Double> averageOfLevels(TreeNode root) {
        
        rt = new ArrayList<>();
        TreeNode curr = root;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(curr);
        
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> tmp = new ArrayList<>();
            while(size-- > 0){
                TreeNode head = q.poll();
                tmp.add(head.val);
                if(head.left != null){
                    q.offer(head.left);
                }
                if(head.right != null){
                    q.offer(head.right);
                }
            }
            double avg = 0.0;
            double cnt = 0.0;
            for(int ele: tmp){
                avg += (double)ele;    
                cnt++;
            }
            rt.add(avg/cnt);
        }
        
        return rt;
    }
    
}