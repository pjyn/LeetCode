class NumArray {

    class SegmentTreeNode{
        private int start, end;
        private SegmentTreeNode left, right;
        private int sum;
        
        public SegmentTreeNode(int start, int end){
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
    }
    
    SegmentTreeNode root = null;
    
    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length-1);
    }
    
    private SegmentTreeNode buildTree(int[] nums, int start, int end){
        if(start > end){
            return null;
        }else{
            SegmentTreeNode ret = new SegmentTreeNode(start, end);
            if(start == end){
                ret.sum = nums[start];      // leaf nodes
            }else{
                int mid = start + (end - start) / 2;
                ret.left = buildTree(nums, start, mid);
                ret.right = buildTree(nums, mid+1, end);
                ret.sum = ret.left.sum + ret.right.sum;
            }
            return ret;
        }
    }
    
    public void update(int index, int val) {
        updateHelper(root, index, val);
    }
    
    void updateHelper(SegmentTreeNode root, int pos, int val){
        if(root.start == root.end) {        // found leaf node to be updated
            root.sum = val;
        }else{
            int mid = root.start + (root.end - root.start) / 2;
            if(pos <= mid){
                updateHelper(root.left, pos, val);
            }else{
                updateHelper(root.right, pos, val);
            }
            root.sum = root.left.sum + root.right.sum;
        }
    }
    
    public int sumRange(int left, int right) {
        return sumRangeHelper(root, left, right);
    }
    
    public int sumRangeHelper(SegmentTreeNode root, int start, int end){
        if(root.end == end && root.start == start){
            return root.sum;
        }else{
            int mid = root.start + (root.end - root.start) / 2;
            if(end <= mid){
                return sumRangeHelper(root.left, start, end);
            }else if(start >= mid+1){
                return sumRangeHelper(root.right, start, end);
            }else{
                return sumRangeHelper(root.left, start, mid) + sumRangeHelper(root.right, mid+1, end);
            }
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */