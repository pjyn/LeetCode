class Solution {
    int[][] res;
    public int[][] diagonalSort(int[][] mat) {
     
        int row = mat.length;
        int col = mat[0].length;
        
        res = new int[row][col];
        
        for(int i=0; i<row; i++){
            
                
            List<Integer> sorted = rec(mat, i, 0, new ArrayList<>());
            insert(mat, i, 0, sorted);
            
        }
        
        for(int j=0; j<col; j++){
            
            List<Integer> sorted = rec(mat, 0, j, new ArrayList<>());
            insert(mat, 0, j, sorted);
        }
        return res;
    }
    
    private List<Integer> rec(int[][] mat, int i, int j, List<Integer> curr){
        
        while(i < mat.length && j < mat[0].length){
            curr.add(mat[i][j]);
            i++;
            j++;
        }
        Collections.sort(curr);
        return curr;
        
    }
    private void insert(int[][] mat, int i, int j, List<Integer> sorted){
        
        int cnt = 0;
        while(i < mat.length && j < mat[0].length){
            res[i][j] = sorted.get(cnt);
            cnt++;
            i++;
            j++;
        }
    }
    
}