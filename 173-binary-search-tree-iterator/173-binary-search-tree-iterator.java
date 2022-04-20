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
class BSTIterator {
    
    List<Integer> res = new ArrayList<>();
    int cnt = 0;
    
    public BSTIterator(TreeNode root) {
        inorder(root);
        
    }
    
    void inorder(TreeNode curr){
        if(curr == null)
            return ;
        
        inorder(curr.left);
        res.add(curr.val);
        inorder(curr.right);
    }
    
    public int next() {
        return res.get(cnt++);
    }
    
    public boolean hasNext() {
        if(cnt < res.size())
            return true;
        return false;
        
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */