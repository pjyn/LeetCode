class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        
        for(int[] a: matrix){
            int l = 0;
            int h = a.length-1;
            while(l <= h){
                int mid = l+(h-l) / 2;
                
                if(a[mid] == target){
                    return true;
                }else if(a[mid] < target){
                    l = mid+1;
                }else{
                    h = mid-1;
                }
            }
        }
        return false;
    }
}