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
 -1, 1->   9
  0, 0->   3
    
 * }
 */
class Solution {
    TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> tm;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        tm = new TreeMap<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 0, 0);
        for(TreeMap<Integer, PriorityQueue<Integer>>tmp: tm.values()){
            List<Integer> rt = new ArrayList<>();
            for(PriorityQueue<Integer> pq: tmp.values()){
                while(!pq.isEmpty()){
                    rt.add(pq.poll())   ;
                }
            }
            res.add(rt);
        }
        return res;
    }
    private void dfs(TreeNode curr, int x, int y){
        if(curr == null)
            return ;
        
        if(!tm.containsKey(x)){
            tm.put(x, new TreeMap<>());
        }
        if(!tm.get(x).containsKey(y)){
            tm.get(x).put(y, new PriorityQueue<>());
        }
        
        tm.get(x).get(y).offer(curr.val);
        dfs(curr.left, x-1, y+1);
        dfs(curr.right, x+1, y+1);
    }
}