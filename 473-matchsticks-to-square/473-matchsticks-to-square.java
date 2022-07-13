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
        reverse(matchsticks);
        return helper(matchsticks, 0, sides);
    }
    private void reverse(int[] matchsticks){
        int i=0;
        int j=matchsticks.length-1;
        
        while(i <= j){
            int tmp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = tmp;
            i++;
            j--;
        }
    }
    
    private boolean helper(int[] nums, int idx, int[] sides){
        
        // if(idx == -1)
        //     return allZero(sides);

        if(idx == nums.length){
            if(sides[0] == 0 && sides[1] == 0 && sides[2] == 0 && sides[3] == 0){
                return true;
            }else{
                return false;
            }
        }
        
        for(int j=0; j<4; j++){
            if(nums[idx] > sides[j])
                continue;
            sides[j] -= nums[idx];
            
            if(helper(nums, idx+1, sides))
                return true;
            sides[j] += nums[idx];    
        }
            
        // }
        return false;
    }
    // private boolean allZero(int[] sides){
    //     for(int i=0; i<sides.length; i++){
    //         if(sides[i] > 0)
    //             return false;
    //     }
    //     return true;
    // }
}