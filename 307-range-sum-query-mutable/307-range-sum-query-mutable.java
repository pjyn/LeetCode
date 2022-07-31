class NumArray {
    int[] nums;
    int[] BIT;
    int n;
    
    public NumArray(int[] nums) {
        this.nums = nums;
        
        n = nums.length;
        BIT = new int[n+1];
        for (int i=0; i<n; i++){
            init(i, nums[i]);
        }
    }
    
    public void init(int i, int val){
        i++;
        while(i <= n){
            BIT[i] += val;
            i += (i & -i);
        }
    }
    
    public void update(int index, int val) {
        int diff = val - nums[index];
        nums[index] = val;
        init(index, diff);
    }
    
    public int getSum(int i){
        int sum = 0;
        i++;
        while(i > 0){
            sum += BIT[i];
            i -= (i & -i);
        }
        return sum;
    }
    
    public int sumRange(int left, int right) {
        return getSum(right) - getSum(left-1);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */