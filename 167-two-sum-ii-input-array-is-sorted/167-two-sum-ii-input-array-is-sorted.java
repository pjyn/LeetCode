class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int l = 0;
        int h = nums.length-1;
        
        while(l <= h){

            int sum = nums[l] + nums[h];
            if(sum > target){
                h -= 1;
            }else if(sum < target){
                l += 1;
            }else{
                return new int[] {l+1, h+1};
            } 
        }
        return new int[] {l+1, h+1};
    }
}