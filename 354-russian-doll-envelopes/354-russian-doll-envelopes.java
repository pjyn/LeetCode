class Solution {
    public int maxEnvelopes(int[][] envelopes) {
     
        Arrays.sort(envelopes, (a,b)-> (a[0]==b[0]) ? (b[1]-a[1]) : (a[0]-b[0]));
        int n = envelopes.length;
        
        int[] dp = new int[n];
        int maxlen = 0;
        
        for(int i=0; i<n; i++){
            
            int index = binarySearch(dp, 0, maxlen, envelopes[i][1]);
            dp[index] = envelopes[i][1];
            
            if(maxlen == index){
                maxlen++;
            }
        }
        return maxlen;
    }
    private int binarySearch(int[] dp, int start, int end, int target){
        
        int index = Arrays.binarySearch(dp, start, end, target);
        if(index < 0){
            index = -(index+1);
        }
        return index;
    }
}