class Solution {
    int[] res;
    public int[] searchRange(int[] nums, int target) {
        res = new int[2];
        res[0] = findStartingIndex(nums, target);
        res[1] = findEndingIndex(nums, target);
            
        return res;
    }
    private int findStartingIndex(int[] nums, int target){
        
        int index = -1;
        int l = 0;
        int h = nums.length-1;
        
        while(l <= h){
            int mid = l + (h-l) / 2;
            
            if(nums[mid] >= target){
                h = mid-1;
            }else{
                l = mid+1;
            }
            
            if(nums[mid] == target){
                index = mid;
            }
        }
        
        return index;
    }
    private int findEndingIndex(int[] nums, int target){
        
        int index = -1;
        int l = 0;
        int h = nums.length-1;
        
        while(l <= h){
            int mid = l + (h-l) / 2;
            
            if(nums[mid] <= target){
                l = mid+1;
            }else{
                h = mid-1;
            }
            if(nums[mid] == target){
                index = mid;
            }
        }
        
        return index;
    }
}