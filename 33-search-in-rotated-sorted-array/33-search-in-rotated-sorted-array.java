class Solution {
    public int search(int[] nums, int target) {
        
        int left = 0;
        int right = nums.length-1;
        
        while(left < right){
            int midpoint = left + (right-left) / 2;
            if(nums[midpoint] > nums[right]){
                left = midpoint+1;
            }else{
                right = midpoint;
            }
        }
        
        int start = left;
        left = 0;
        right = nums.length-1;
        
        if(nums[start] <= target && target <= nums[right]){
            left = start;
        }else{
            right = start;
        }
        
        while(left <= right){
            int mid = left + (right-left) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid-1;
            }
        }
        return -1;
    }
}