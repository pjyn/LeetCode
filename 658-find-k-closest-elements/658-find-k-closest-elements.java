class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        List<Integer> res = new ArrayList<>();
        
        // |a-x| < |b-x|
        int low = 0;
        int high = arr.length-1;
        while(high - low >= k) {
            if(Math.abs(arr[low] - x) > Math.abs(arr[high] - x)){
                // [1, 2, 3, 4, 5]-> x = 3
                // 1 - 3 > 5 - 3 => 2 > 2
                low++;
            }else{
                high--;
            }
        }
        
        for(int i=low; i<=high; i++){
            res.add(arr[i]);
        }
        return res;
    }
}