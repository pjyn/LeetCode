class Solution {
    
    private int[][] dir = new int[][]{{0,1}, {1,0}, {-1, 0}, {0,-1},{-1,-1},{-1,1},{1,-1},{1,1}};
    
    public void gameOfLife(int[][] board) {
        
        // 3-> lives
        // -2 -> dies
        
        int row = board.length;
        int col = board[0].length;
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                
                if(board[i][j] == 1){
                    int tmp = helper(i, j, board, row, col);
                    if(tmp < 2 || tmp > 3){
                        board[i][j] = -2;
                    }
            
                }else if(board[i][j] == 0){
                    int tmp = helper(i, j, board, row, col);
                    if(tmp == 3){
                        board[i][j] = 3;
                    }
                }
            }
        }
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                
                if(board[i][j] == 3){
                    board[i][j] = 1;
                }
                if(board[i][j] == -2){
                    board[i][j] = 0;
                }
            }
        }
    }
    
    private int helper(int i, int j, int[][] board, int row, int col){
        
        int active = 0;

        for(int[] direction: dir){
            
            int newRow = i+direction[0];
            int newCol = j+direction[1];
            
            if(newRow >= 0 && newRow < row && newCol >= 0 && newCol < col && (board[newRow][newCol] == 1 || board[newRow][newCol] == -2)){
                active++;
            }
        }
        
        return active;
    }
}