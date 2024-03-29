class Solution {
    public void rotate(int[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        /*
            1   4   7
            2   5   8
            3   6   9
            
            7   4   1
            8   5   2
            9   6   3
        */
        
        for(int i=0; i<n; i++){
            for(int j=i; j<m; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m/2; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][m-1-j];
                matrix[i][m-1-j] = tmp;
            }
        }
    }
}