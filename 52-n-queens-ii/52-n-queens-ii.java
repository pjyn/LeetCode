class Solution {
    List<List<String>> result;
    public int totalNQueens(int n) {
        
        result = new ArrayList<>();
        char[][] board = new char[n][n];
        
        for(char[] a: board){
            Arrays.fill(a, '.');
        }
        
        List<int[]> q = new ArrayList<>();
        dfs(board, 0, q);
        return result.size();
    }
    private void dfs(char[][] board, int r, List<int[]> q){
        if(q.size() == board.length){
            
            List<String> list = new ArrayList<>();
            
            for(char[] arr: board){
                list.add(new String(arr));
            }
            result.add(list);
        }
        
        //+++++++++++++++++++++
        for(int c=0; c<board.length; c++){
            if(isSafe(r, c, q)){
                board[r][c] = 'Q';
                q.add(new int[]{r, c});
                dfs(board, r+1, q);
                board[r][c] = '.';
                q.remove(q.size()-1);
            }
        }
    }
    
    private boolean isSafe(int r, int c, List<int[]> q){
        
        for(int[] a: q){
            int dx = Math.abs(r - a[0]);
            int dy = Math.abs(c - a[1]);
            if(dx == 0 || dy == 0 || dy == dx)
                return false;
        }
        return true;
    }
}