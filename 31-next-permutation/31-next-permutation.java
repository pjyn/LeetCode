class Solution {
    public void nextPermutation(int[] nums) {
        
        int first = nums.length-1;
        
        while(first >= 1 && nums[first] <= nums[first-1]){
            first--;
        }
        
        if(first == 0){
            Arrays.sort(nums);
            return ;
        }
        
        first--;
        
        int second = nums.length-1;
        while(first < second && nums[second] <= nums[first]){
            second--;
        }
        
        
        
        swap(nums, first, second);
        
        first = first+1;
        second = nums.length-1;
        
        while(first < second){
            int tmp = nums[first];
            nums[first] = nums[second];
            nums[second] = tmp;
            second--;
            first++;
        }
        // [2, 3, 1]    
        //  f     s
    }
    
    private void swap(int[] nums, int first, int second){
        
        int tmp = nums[first];
        nums[first] = nums[second];
        nums[second] = tmp;
    }
}