/*
    Arrays/2D Arrays
    Strings
    Searching & Sorting
    Backtracking
    Linked List
    Stacks & Queues
    Trees/BST
    Graphs
    Dynamic Programming 
    Tries
    Segment Trees (basic)
    Bit Manipulation
*/





class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        int maxSum = 0;
        int runningSum = 0;
        int i = 0; 
        int start = 0;
        while(i < nums.length){
            
            if(!hs.contains(nums[i])){
                hs.add(nums[i]);
                runningSum += nums[i];
                maxSum = Math.max(maxSum, runningSum);
                i++;
            }else{
                
                hs.remove(nums[start]);
                runningSum -= nums[start];
                start++;
            }
            
        }
        return maxSum;
    }
}