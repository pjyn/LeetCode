class Solution {
    public boolean find132pattern(int[] nums) {
        
        int secondMax = Integer.MIN_VALUE;
        
        Stack<Integer> st = new Stack<>();
        
        for(int i=nums.length-1; i>=0; i--){
            
            if(nums[i] < secondMax)
                return true;
            
            while(!st.isEmpty() && nums[i] > st.peek()){
                secondMax = Math.max(secondMax, st.pop());
            }
            st.push(nums[i]);
        }
        return false;
    }
}