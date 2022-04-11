class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        int total = m*n;
        k = k%total;        // 4%16
        
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i=0; i<m; i++){
            List<Integer> subList = new ArrayList<>();
            for(int j=0; j<n; j++){
                
                int idx = findShiftedIndex(i, j, n, k, total);
                subList.add(grid[idx/n][idx%n]);
            }
            res.add(subList);
        }
        return res;
    }
    
    public int findShiftedIndex(int i, int j, int col, int k, int total){
        int index = (i * col + j + total - k) % total;
        
        return index;
    }
}