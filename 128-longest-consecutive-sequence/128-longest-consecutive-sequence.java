class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> hs = new HashSet<>();
        for(int i: nums){
            hs.add(i);
        }
        
        int longestStreak = 0;
        
        for(int i: nums){
            if(!hs.contains(i-1)){
                int current = i;
                int tmp = 1;
                
                while(hs.contains(current+1)){
                    current += 1;
                    tmp++;
                }
                longestStreak = Math.max(longestStreak, tmp);
            }
        }
        return longestStreak;
    }
}