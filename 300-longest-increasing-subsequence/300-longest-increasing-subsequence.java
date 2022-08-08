class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int[][] dp = new int[nums.length][nums.length];
        return rec(dp, -1, 0, nums);
    }
    
    private int rec(int[][] dp, int prev, int curr, int[] nums){
        
        if(curr == nums.length){
            return 0;
        }
        
        if(prev != -1 && dp[prev][curr] != 0){
            return dp[prev][curr];
        }
        
        int op1 = 0;
        if(prev == -1 || nums[prev] < nums[curr]){
            op1 = 1 + rec(dp, curr, curr+1, nums);
        }
        int op2 = rec(dp, prev, curr+1, nums);
        
        if(prev != -1){
            dp[prev][curr] = Math.max(op1, op2);    
        }
        
        return Math.max(op1, op2);
    }
}