class Solution {
    public int numIslands(char[][] grid) {
     
        int row = grid.length;
        int col = grid[0].length;
        
        int ans = 0;
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                
                ans += dfs(i, j, grid);
            }
        }
        return ans;
    }
    
    private int dfs(int i, int j, char[][] grid){
        
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0'){
            return 0;
        }
        grid[i][j] = '0';
        
        dfs(i-1, j, grid);
        dfs(i+1, j, grid);
        dfs(i, j-1, grid);
        dfs(i, j+1, grid);
        
        return 1;
    }
}