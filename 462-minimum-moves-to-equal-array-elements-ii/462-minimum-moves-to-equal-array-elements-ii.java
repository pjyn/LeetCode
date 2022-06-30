class Solution {
    public int minMoves2(int[] nums) {
        
        // List<Integer> r = new ArrayList<>();
        
        Arrays.sort(nums);
        // for(int i: nums){
        //     r.add(i);
        // }
        
        // Collections.sort(r);
        // [1, 2, 3]
        int size = nums.length;
        int median = nums[size/2];
        
        int ans = 0;
        for(int i: nums){
            ans += Math.abs(i-median);
        }
        return ans;
    }
}