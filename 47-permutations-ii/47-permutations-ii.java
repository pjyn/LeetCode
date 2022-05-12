class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        int n = nums.length;
        Set<List<Integer>> setAns = new HashSet<>();
        
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[n];
        
        backtrack(nums, setAns, visited, new ArrayList<>());
        
        for(List<Integer> e: setAns){
            ans.add(e);
        }
        
        return ans;
    }
    private void backtrack(int[] nums, Set<List<Integer>> setAns, boolean[] visited, List<Integer> currList){
        
        if(currList.size() == nums.length){
            setAns.add(new ArrayList<>(currList));
        }
        
        for(int i=0; i<nums.length; i++){
            if(!visited[i]){
                currList.add(nums[i]);
                visited[i] = true;
                backtrack(nums, setAns, visited, currList);
                visited[i] = false;
                currList.remove(currList.size()-1);
            }
        }
    }
}