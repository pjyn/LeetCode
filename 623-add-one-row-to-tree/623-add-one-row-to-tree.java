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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        
        if(depth == 1){
            TreeNode r = new TreeNode(val);
            r.left = root;
            return r;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.offer(root);
        depth = depth-1;
        int level = 1;
        
            
        while(level != depth){
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
            level++;
        }
        while(!q.isEmpty()){
            TreeNode head = q.poll();
            TreeNode leftChild = head.left;
            TreeNode rightChild = head.right;
            
            TreeNode newLeft = new TreeNode(val);
            TreeNode newRight = new TreeNode(val);
            
            head.left = newLeft;
            head.right = newRight;
            newLeft.left = leftChild;
            newRight.right = rightChild;
        }
        return root;
    }
}