class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i=0; i<nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            
    
            int l = i+1, r = nums.length-1;
            while(l < r){
                int tmp = nums[i] + nums[l] + nums[r];
                if (tmp > 0){
                    r--;
                }else if(tmp < 0){
                    l++;
                }else{
                    List<Integer> qwe = new ArrayList<>();
                    qwe.add(nums[i]);
                    qwe.add(nums[l]);
                    qwe.add(nums[r]);
                    // qwe.add(new Integer[]{nums[i], nums[l], nums[r]});
                    res.add(qwe);
                    l++;
                    while(nums[l] == nums[l-1] && l < r){
                        l++;
                    }
                }
            }
        }
        return res;
    }
}