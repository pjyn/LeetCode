class Solution {
    public int reversePairs(int[] nums) {
     
        return mergeSort(nums, 0, nums.length-1);
    }
    
    int mergeSort(int[] nums, int low, int high){
        if(low >= high)
            return 0;
        int mid = (low + high) / 2; 
        int inv = mergeSort(nums, low, mid);
        inv += mergeSort(nums, mid+1, high);
        inv += merge(nums, low, mid, high);
        return inv;
    }
    int merge(int[] nums, int low, int mid, int high){
        int cnt = 0;
        int j = mid+1;
        for(int i=low; i<=mid; i++){
            while(j <= high && nums[i] > (2*(long) nums[j])) {
                j++;   
            }
            cnt += (j - (mid+1));
        }
        
        ArrayList<Integer> tmp = new ArrayList<>();
        int left = low, right = mid+1;
        while(left <= mid && right <= high){
            if(nums[left] <= nums[right]){
                tmp.add(nums[left++]);
            }else{
                tmp.add(nums[right++]);
            }
        }
        
        while(left <= mid){
            tmp.add(nums[left++]);
        }
        while(right <= high){
            tmp.add(nums[right++]);
        }
        for(int i=low; i<=high; i++){
            nums[i] = tmp.get(i- low);
        }
        return cnt;
    }
}