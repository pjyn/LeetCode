class Solution {
    Map<Integer, List<Integer>> hm = new HashMap<>();

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        for(int i=0; i<n; i++){
            hm.put(i, new ArrayList<>());
        }
        /*
            0-> []
            1-> []
            2-> []
        */
        
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            
            hm.get(u).add(v);
            hm.get(v).add(u);
        }
        Set<Integer> vis = new HashSet<>();
        return dfs(source, destination, vis);
        
    }
    private boolean dfs(int src, int des, Set<Integer> vis){
        if(src == des){
            return true;
        }
        
        if(vis.contains(src))
            return false;
        
        vis.add(src);
        
        for(int a: hm.get(src)){
            
            if(dfs(a, des, vis)){
                return true;
            }
        }
        return false;
    }
}