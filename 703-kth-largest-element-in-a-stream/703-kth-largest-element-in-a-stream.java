class KthLargest {
    PriorityQueue<Integer> min_heap;
    int e;
    
    public KthLargest(int k, int[] nums) {
        
        e = k;
        min_heap = new PriorityQueue<>( (a, b)-> (a-b));
        
        for(int ele: nums){
            min_heap.offer(ele);
        }
        
        while(min_heap.size() > k){
            min_heap.poll();
        }
    }
    
    public int add(int val) {
        min_heap.offer(val);
        
        if(min_heap.size() > e){
            min_heap.poll();
        }
        
        return min_heap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */