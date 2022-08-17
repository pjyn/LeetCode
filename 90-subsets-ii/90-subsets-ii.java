class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
     
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), nums, 0, false);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> curr, int[] nums, int pos, boolean choosePre){
        if(pos == nums.length){
            res.add(new ArrayList<>(curr));
            return ;
        }
        
        helper(res, curr, nums, pos+1, false);
        if(pos >= 1 && nums[pos] == nums[pos-1] && !choosePre)
            return ;
        curr.add(nums[pos]);
        helper(res, curr, nums, pos+1, true);
        curr.remove(curr.size()-1);
    }
}