class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        
        List<Integer> cur = new ArrayList<>();
        int n = graph.length;
        boolean[] vis = new boolean[n];
        cur.add(0);
        dfs(vis, 0, cur, res, graph, n-1);
        return res;
    }
    
    private void dfs(boolean[] vis, int src, List<Integer> cur, List<List<Integer>> res, int[][] graph, int n){
        
        if(src == n){
            res.add(new ArrayList(cur));
            return ;
        }
        
        vis[src] = true;
        
        for(int a: graph[src]){
            cur.add(a);
            dfs(vis, a, cur, res, graph, n);
            cur.remove(cur.size()-1);
        }
    }
}