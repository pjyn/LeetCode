/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
     
        List<List<Integer>> res = new ArrayList<>();
        Node curr = root;
        if(curr == null){
            return res;
        }
        
        Queue<Node> q = new LinkedList<>();
        q.offer(curr);
        
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> tmp = new ArrayList<>();
            while(size-- > 0){
                Node head = q.poll();
                if(head != null){
                    tmp.add(head.val);
                }
                for(Node op: head.children){
                    q.offer(op);
                }
            }
            res.add(tmp);
        }
        return res;
    }
}