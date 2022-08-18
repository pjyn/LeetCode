class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        res = new ArrayList<>();
        
        Arrays.sort(candidates);
        // [1, 1, 2, 5, 6, 7, 10]
        rec(0, candidates, target, new ArrayList<>());
        return res;
    }
    private void rec(int index, int[] candidates, int target, List<Integer> curr){
        
        if(target == 0){
            res.add(new ArrayList<>(curr));
            return ;
        }   
        
        if(target < 0)
            return ;
        
        for(int i=index; i<candidates.length; i++){
            if(i > index && candidates[i] == candidates[i-1])
                continue;
            
            
            curr.add(curr.size(), candidates[i]);
            rec(i+1, candidates, target-candidates[i], curr);
            curr.remove(curr.size()-1);
        }
    }
}