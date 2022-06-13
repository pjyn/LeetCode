class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        curr.add(0);
        dfs(0, curr, res, graph.length-1, graph);
        return res;
    }
    
    private void dfs(int src, List<Integer> curr, List<List<Integer>> res, int dest, int[][] graph){
        if(src == dest){
            res.add(new ArrayList<>(curr));
            return ;
        }
        
        for(int a: graph[src]){
            curr.add(a);
            dfs(a, curr, res, dest, graph);
            curr.remove(curr.size()-1);
        }
    }
}