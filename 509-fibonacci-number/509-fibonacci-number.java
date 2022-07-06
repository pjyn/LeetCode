class Solution {
    public int fib(int n) {
        
        if(n == 0){
            return 0;
        }
        int[] dp = new int[n+1];
        
        // 1 1 2 
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i=2; i<=n; i++){
            return fib(n-1) + fib(n-2);
        }
        return dp[n];
    }
}