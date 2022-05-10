class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        Set<List<Integer>> res = new HashSet<>();
        backtrack(res, k, n, new HashSet<>(), 1);
        return new ArrayList<>(res);
    }
    
    private void backtrack(Set<List<Integer>> res, int elements, int remainingSum, HashSet<Integer> hs, int start){
        
        if(elements == 0){
            if(remainingSum == 0){
                res.add(new ArrayList<>(hs));
                return ;
            }else{
                return ;
            }
        }
        
        if(remainingSum < 0){
            return ;
        }
        
        for(int i=1; i<=9; i++){
            if(!hs.contains(i)){
                hs.add(i);
                backtrack(res, elements-1, remainingSum-i, hs, start+1);
                hs.remove(i);
            }
        }
    }
}