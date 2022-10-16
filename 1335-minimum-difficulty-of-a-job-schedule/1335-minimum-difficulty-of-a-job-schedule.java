class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        
        if(jobDifficulty.length < d){
            return -1;
        }
        
        int[][] dp = new int[d+1][jobDifficulty.length];
        for(int[] p: dp){
            Arrays.fill(p, -1);
        }
        
        return dfs(jobDifficulty, dp, d, 0);
    }
    
    public int dfs(int[] jobDifficulty, int[][] dp, int d, int index){
        if(d == 1){
            int max = 0;
            while(index < jobDifficulty.length){
                max = Math.max(max, jobDifficulty[index++]);
            }
            return max;
        }
        
        if(dp[d][index] != -1){
            return dp[d][index];
        }
        
        int leftMax = 0;
        int res = Integer.MAX_VALUE;
        for(int i=index; i<jobDifficulty.length-d+1; i++){
            leftMax = Math.max(leftMax, jobDifficulty[i]);
            res = Math.min(res, leftMax+dfs(jobDifficulty, dp, d-1, i+1));
        }
        
        return dp[d][index] = res;
    }
}