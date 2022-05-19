class Solution {
    
    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int longestIncreasingPath(int[][] matrix) {
        
        if(matrix == null || matrix.length == 0)
            return 0;
        
        int m = matrix.length;
        int n = matrix[0].length;
        int maxLength = 0;
        
        int[][] dp = new int[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int currentPath = dfs(i, j, matrix, m, n, dp);
                maxLength = Math.max(maxLength, currentPath);
            }
        }
        
        return maxLength;
    }
    private int dfs(int i, int j, int[][] matrix, int m, int n, int[][] dp){
        
        // if(i < 0 || j < 0 || i >= m || j >= n)
        //     return 0;
        
        if(dp[i][j] > 0){
            return dp[i][j];
        }
        int currentLen = 0;
        
        for(int[] d: dir){
            int x = i + d[0];
            int y = j + d[1];
            
            if(x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]){
                currentLen = Math.max(currentLen, dfs(x, y, matrix, m, n, dp));
            }
        }
        dp[i][j] = currentLen+1;
        return currentLen+1;
    }
}