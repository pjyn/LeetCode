class Solution {
    int cnt = 0;
    public int countSubstrings(String s) {
        
        if(s.length() == 0 || s == null){
            return 0;
        }
        
        for(int i=0; i<s.length(); i++){
            energyGems(s, i, i);
            energyGems(s, i, i+1);
        }
        return cnt;
    }
    private void energyGems(String s, int left, int right){
    
        while(left>=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            cnt++;
            left--;
            right++;
        }
    }
}