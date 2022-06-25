class Solution {
    public boolean checkPossibility(int[] nums) {
        
        int cnter = 0;
        for(int i=1; i<nums.length; i++){
            if(nums[i-1] > nums[i]){
                cnter++;
                if(i-2 < 0 || nums[i-2] <= nums[i])
                    nums[i-1] = nums[i];
                else
                    nums[i] = nums[i-1];
            }
            
        }
        return cnter <= 1;
//         int[] clone = nums.clone();
        
//         Arrays.sort(clone);
        
//         int cnter = 0;
//         for(int i=0; i<nums.length; i++){
//             if(clone[i] != nums[i]){
//                 cnter++;
//                 if(cnter > 1){
//                     return false;
//                 }
//             }
//         }
//         return true;
        
        /* 
            [4, 2, 3]
            [2, 3, 4]
        */
    }
}