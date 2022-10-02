class Solution {
    int mod = 1_000_000_007;
    public int numRollsToTarget(int dices, int faces, int target) {
        
        // 'n' dice 
        // each die has 'k' faces
        long[] dp = new long[target+1];
        dp[0] = 1;
        
//         if(dices == 1){
//             if(target >= 1 && target <= 6){
//                 return 1;
//             }else{
//                 return 0;
//             }
//         }
        
        
        
        for(int i=1; i<=dices; i++){
            for(int j=target; j>=0; j--){
                dp[j] = 0;
                for(int k=1; k<=faces; k++){
                    if(j >= k){
                        dp[j] = (dp[j] + dp[j-k]) % mod;
                    }else{
                        break;
                    }
                }
            }
        }
        return (int)dp[target];
    }
}