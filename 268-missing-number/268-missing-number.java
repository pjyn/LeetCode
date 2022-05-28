class Solution {
    public int missingNumber(int[] nums) {
        
        Arrays.sort(nums);
        
        // [0, 1, 2]
        int i = 0;
        boolean isOk = false;
        
        while(i < nums.length){
            if(nums[i] != i){
                isOk = true;
                return i;
            }
            i++;
        }
        if(!isOk){
            return nums.length;
        }
        return 0;
    }
}