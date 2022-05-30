class Solution {
    public void rotate(int[][] matrix) {
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        //transpose
        for(int i=0; i<row; i++){
            for(int j=i; j<col; j++){
                int tmp = matrix[i][j];     // col-val
                matrix[i][j] = matrix[j][i];    // row-val
                matrix[j][i] = tmp;
            }
        }
        
        // swap row-wise
        for(int i=0; i<row; i++){
            for(int j=0; j<row/2; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][col-1-j];
                matrix[i][col-1-j] = tmp;
            }
        }
        
    }
}