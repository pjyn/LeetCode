class Solution {
    public int missingNumber(int[] nums) {
        
        Arrays.sort(nums);
        int totalSum = 0;
        int runningSum = 0;
        
        for(int i=0; i<nums.length; i++){
            if(i != 0){
                totalSum += i;
            }
            runningSum += nums[i];
        }
        totalSum += nums.length;
    
        return totalSum - runningSum;
    }
}