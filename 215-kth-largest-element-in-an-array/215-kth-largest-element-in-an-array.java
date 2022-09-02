class Solution {
    public int findKthLargest(int[] nums, int k) {
            
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)-> (b-a));
        for(int i: nums){
            pq.offer(i);
        }
        while(k-- > 1){
            pq.poll();
        }
        return pq.poll();
        // Arrays.sort(nums);
        // int n = nums.length;
        // return nums[n-k];

    }
}