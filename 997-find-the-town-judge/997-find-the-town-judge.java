class Solution {
    public int findJudge(int n, int[][] trust) {
     
        /*
            1. T.j trust nobody
            2. everbody trust town judge
            
            [0, -1, -1, 2]
        */
        
        int[] count = new int[n+1];
        for(int[] t: trust){
            count[t[0]]--;  // town judge trusts nobody
            count[t[1]]++;     // increment the contender value
        }
        
        for(int i=1; i<=n; i++){
            if(count[i] == n-1)     
                return i;
        }
        return -1;
    }
}