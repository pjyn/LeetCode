class Solution {
    public int threeSumClosest(int[] nums, int target) {
     
        int result = nums[0] + nums[1] + nums[nums.length-1];
        Arrays.sort(nums);
        
        // [-4, -1, 1, 2]
        
        for(int i=0; i<nums.length-2; i++){
            
            int first = i+1;
            int second = nums.length-1;
            
            while(first < second){
                int sum = nums[i] + nums[first] + nums[second];
                if(sum > target){
                    second--;
                }else{
                    first++;
                }
                
                if(Math.abs(sum-target) < Math.abs(result - target))
                    result = sum;
            }
        }
        return result;
    }
}