class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null)
            return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        
        if(canDeleteNode(root))
            return null;
        return root;
    }
    private boolean canDeleteNode(TreeNode node){
        if(node.left == null && node.right == null && node.val == 0){
            return true;
        }else{
            return false;
        }
    }
}