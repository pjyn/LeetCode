class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        
        int[] output_arr = new int[queries.length];
        
        int even_sum = 0;
        for(int val: nums){
            if(val % 2 == 0){
                even_sum += val;
            }
        }
        // even_sum = 6
        
        for(int i=0; i<queries.length; i++){
            int index = queries[i][1];      // 0
            int value = queries[i][0];      // 1
            
            if(nums[index] % 2 == 0){           // 1%2
                even_sum -= nums[index];
            }
            
            nums[index] += value;           // 1 + 1
            if(nums[index] % 2 == 0){
                even_sum += nums[index];        // 6 += 2 => 8
            }
            
            output_arr[i] = even_sum;
        }
        
        return output_arr;
    }
}