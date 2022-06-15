class Solution {
    public void nextPermutation(int[] nums) {
        
        int first = nums.length-1;
        while(first >= 1 && nums[first-1] >= nums[first]){
            first--;
        }
        
        if(first == 0){
            Arrays.sort(nums);
            return ;
        }
        first--;
        
        int second = nums.length-1;
        while(first < second && nums[first] >= nums[second]){
            second--;
        }
        
        // second--;
        swap(nums, first, second);
        int start = first+1;
        int end = nums.length-1;
        while(start < end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            end--;
            start++;
        }
    }
    
    
    private void swap(int[] nums, int a, int b){
        if(a != b){
            int tmp = nums[b];
            nums[b] = nums[a];
            nums[a] = tmp;    
        }
    }
}