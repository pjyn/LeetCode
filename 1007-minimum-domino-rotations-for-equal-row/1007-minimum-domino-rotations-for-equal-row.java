class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        
        int minSwaps = Math.min(numSwaps(tops[0], tops, bottoms), numSwaps(bottoms[0], tops, bottoms));
        
        minSwaps = Math.min(minSwaps, numSwaps(tops[0], bottoms, tops));
        minSwaps = Math.min(minSwaps, numSwaps(bottoms[0], bottoms, tops));
        return minSwaps == Integer.MAX_VALUE ? -1 : minSwaps;
    }
    
    private int numSwaps(int target, int[] A, int[] B){
        int numSwaps = 0;
        for(int i=0; i<A.length; i++){
            if(A[i] != target && B[i] != target){
                return Integer.MAX_VALUE;
            }else if(A[i] != target){
                numSwaps++;
            }
        }
        return numSwaps;
    }
}