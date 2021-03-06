class Solution {
    public int wiggleMaxLength(int[] nums) {
     
        int up = 1, down = 1;
        
        for(int i=0; i<nums.length-1; i++){
            if(nums[i+1] > nums[i]){
                up = down+1;
            }else if(nums[i] > nums[i+1]){
                down = up+1;
            }
        }
        return Math.max(up, down);
    }
}