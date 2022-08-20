class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        
        boolean[] vis = new boolean[nums.length];
        res = new ArrayList<>();
        rec(nums, new ArrayList<>(), vis);
        return res;
    }
    
    private void rec(int[] nums, List<Integer> curr, boolean[] vis){
        
        if(curr.size() == nums.length){
            res.add(new ArrayList<>(curr));
            return ;
        }
        
        for(int i=0; i<nums.length; i++){
            if(vis[i])
                continue;
            
            curr.add(nums[i]);
            vis[i] = true;
            rec(nums, curr, vis);
            curr.remove(curr.size()-1);
            vis[i] = false;
        }
    }
}