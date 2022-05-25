class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        
        Arrays.sort(envelopes, (a, b)-> (a[0]==b[0]) ? (b[1]-a[1]) : (a[0]-b[0]));
                
        int[] dp = new int[envelopes.length];
        
        int max = 0;
        
        for(int i=0; i<dp.length; i++){
            
            // find index of height of envelope[i]
            int index = binarySearch(dp, 0, max, envelopes[i][1]);
            
            dp[index] = envelopes[i][1];
            
            if(index == max){
                max++;
            }
        }
        return max;
    }
    
    int binarySearch(int[] arr, int start, int end, int target){
        int index = Arrays.binarySearch(arr, start, end, target);
        if(index < 0){
            index = -(index+1);
        }
        return index;
    }
}