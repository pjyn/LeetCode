class Solution {
    public int[][] generateMatrix(int n) {
        
        int[][] res = new int[n][n];
        
        int row_start = 0;
        int row_end = n-1;
        int col_start = 0;
        int col_end = n-1;
        int cnt = 1;
        
        while(row_start <= row_end && col_start <= col_end){
            
            for(int j=col_start; j<=col_end; j++){
                res[row_start][j] = cnt++;
            }
            row_start++;
            
            for(int j=row_start; j<=row_end; j++){
                res[j][col_end] = cnt++;
            }
            col_end--;
            
            // for(int j=col_end; j>=col_start; j--){
            //     res[row_end][j] = cnt++;
            // }
            // row_end--;
            
            if(row_start <= row_end){
                for(int j=col_end; j>=col_start; j--){
                    res[row_end][j] = cnt++;
                }
                row_end--;
            }
            
            if(col_start <= col_end){
                for(int j=row_end; j>=row_start; j--){
                    res[j][col_start] = cnt++;
                }
            }
            col_start++;
        }
        return res;
    }
}