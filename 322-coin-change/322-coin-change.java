class Solution {
    public int coinChange(int[] coins, int amount) {
     
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        // [12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12]
        dp[0] = 0;
        
        for(int coin: coins){
            // [1, 2, 5]
            for(int i=coin; i<=amount; i++){
                // [1....11]
                dp[i] = Math.min(dp[i], dp[i-coin]+1);
            }
        }
        return dp[amount] <= amount ?  dp[amount] : -1;
    }
}