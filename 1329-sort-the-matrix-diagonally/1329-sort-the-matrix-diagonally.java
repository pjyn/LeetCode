class Solution {
    int[][] res;
    // boolean[][] vis;
    public int[][] diagonalSort(int[][] mat) {
     
        int row = mat.length;
        int col = mat[0].length;
        
        res = new int[row][col];
        // vis = new boolean[row][col];
        
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
        
//         if(i < 0 || i > mat.length || j < 0 || j > mat[0].length || vis[i][j]){
//             Collections.sort(curr);
//             return curr;
//         }
        
//         vis[i][j] = true;
        
        // rec(mat, i+1, j+1, curr);
        while(i < mat.length && j < mat[0].length){
            curr.add(mat[i][j]);
            i++;
            j++;
        }
        Collections.sort(curr);
        // for(int i: curr){
        //     System.out.println(i);
        // }
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