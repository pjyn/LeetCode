class Solution {
    public boolean makesquare(int[] matchsticks) {
        
        if(matchsticks.length < 4)
            return false;
        
        int perimeter = IntStream.of(matchsticks).sum();
        
        
        if(perimeter % 4 != 0)
            return false;
        
        int side = perimeter/4;
        int[] sides = new int[]{side, side, side, side};
        
        Arrays.sort(matchsticks);
        return helper(matchsticks, matchsticks.length-1, sides);
    }
    
    private boolean helper(int[] nums, int idx, int[] sides){
        
        if(idx == -1)
            return allZero(sides);
        
        
        for(int j=0; j<sides.length; j++){
            if(nums[idx] <= sides[j]){
                
                sides[j] -= nums[idx];
                if(helper(nums, idx-1, sides))
                    return true;
                sides[j] += nums[idx];    
            }
            
        }
        return false;
    }
    private boolean allZero(int[] sides){
        for(int i=0; i<sides.length; i++){
            if(sides[i] > 0)
                return false;
        }
        return true;
    }
}