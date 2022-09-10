class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
     
        List<Integer> res = new ArrayList<>();
        
        if(nums == null || k <= 0)
            return new int[0];
        
        int n = nums.length;
        Deque<Integer> q = new ArrayDeque<>();
        
        for(int i=0; i<n; i++){
            
            while(!q.isEmpty() && q.peek() < i - k + 1){
                q.poll();
            }
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i]){
                q.pollLast();
            }
            
            q.offer(i);
            if(i >= k-1){
                res.add(nums[q.peek()]);
            }
        }
        
        return res.stream().mapToInt(x-> x).toArray();
    }
}