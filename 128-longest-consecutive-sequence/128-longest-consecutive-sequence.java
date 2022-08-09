class Solution {
    public int longestConsecutive(int[] nums) {
        
        // Arrays.sort(nums);
        // [1, 2, 3, 4, 100, 200]
        // [0, 0, 1, 2, 3, 4, 5, 6, 7, 8]
        
        
        HashSet<Integer> hs = new HashSet<>();
        for(int i: nums){
            hs.add(i);
        }
        
        int longestStreak = 0;
        
        for(int ele: nums){
            
            if(!hs.contains(ele-1)){
                int curr = ele;
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