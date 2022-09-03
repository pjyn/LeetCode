class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        
        // |1st-2nd| = k
        List<Integer> list = new ArrayList<>();
        dfs(n, k, list, 0);
        int[] ans = new int[list.size()];
        int cnt = 0;
        for(int i: list){
            ans[cnt++] = i;
        }
        return ans;
    }
    
    private void dfs(int n, int k, List<Integer> list, int currNo){
        if(n <= 0){
            list.add(currNo);
            return ;
        }
        
        for(int i=0; i<10; i++){
            if(i == 0 && currNo == 0){
                continue;
            }else if(i != 0 && currNo == 0){
                dfs(n-1, k, list, i);
            }else if(Math.abs(currNo%10 - i) == k){
                dfs(n-1, k, list, currNo*10+i);
            }
        }
    }
}