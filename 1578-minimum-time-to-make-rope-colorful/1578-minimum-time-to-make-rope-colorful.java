class Solution {
    public int minCost(String colors, int[] neededTime) {
        
        char c = '*';
        int costp = 0;
        int ans = 0;
        
        for(int i=0; i<colors.length(); i++){
            if(colors.charAt(i) == c){
                
                if(costp < neededTime[i]){
                    ans += costp;
                    costp = neededTime[i];
                }else{
                    ans += neededTime[i];
                }
            }else{
                c = colors.charAt(i);
                costp = neededTime[i];
            }
        }
        return ans;
    }
}