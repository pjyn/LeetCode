class Solution {
    public int kthSmallest(int[][] matrix, int k) {
     
        /*
        [
         [1 ,5 ,9],
         [10,11,13],
         [12,13,15]
        ]
        */
        List<Integer> a = new ArrayList<>();
        int n = matrix.length;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                a.add(matrix[i][j]);
            }
        }
        // [1, 5, 9, 10, 11, 12, 13, 15]
        Collections.sort(a);
        return a.get(k-1);
    }
}