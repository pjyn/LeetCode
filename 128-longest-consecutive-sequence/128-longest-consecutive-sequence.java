class Solution {
    public int longestConsecutive(int[] nums) {
        
        HashSet<Integer> hs = new HashSet<>();
        
        for(int i: nums){
            hs.add(i);
        }
        
        int longestStreak = 0;
        for(int i=0; i<nums.length; i++){
            if(!hs.contains(nums[i]-1)){
                int curr = nums[i];
                int tmp = 1;
                
                while(hs.contains(curr+1)){
                    curr++;
                    tmp++;
                }
                longestStreak = Math.max(longestStreak, tmp);
            }
        }
        return longestStreak;
    }
}