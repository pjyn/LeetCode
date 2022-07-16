class Solution {
    
    private Long[][][] memo = null;
    private int mod = 1000000007;
    
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        
        memo = new Long[m+1][n+1][maxMove+1];
        return (int)(dfs(m, n, maxMove, startRow, startColumn));
    }
    
    private long dfs(int m, int n, int maxMove, int row, int col){
        
        if(maxMove < 0){
            return 0;
        }
        
        if(row == m || col == n || row < 0 || col < 0)      // exit condition
            return 1;
        
        if(memo[row][col][maxMove] != null)
            return memo[row][col][maxMove];
        
        long total = 0;
        long left_move = dfs(m, n, maxMove-1, row, col-1);
        long right_move = dfs(m, n, maxMove-1, row, col+1);
        long down_move = dfs(m, n, maxMove-1, row+1, col);
        long up_move = dfs(m, n, maxMove-1, row-1, col);  
        
        total = (left_move+right_move+down_move+up_move)%mod;
        memo[row][col][maxMove] = total;
        return total;
    }
}