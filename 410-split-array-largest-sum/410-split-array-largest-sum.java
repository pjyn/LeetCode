class Solution {
    public int splitArray(int[] nums, int m) {
        
        int maxNo = 0;
        long total = 0;
        
        for(int ele: nums){
            maxNo = Math.max(ele, maxNo);
            total += ele;
        }
        
        long low = maxNo;
        long high = total;
        
        while(low < high){
            long mid = low + (high-low)/2;
            
            if(validDivisionPossible(mid, nums, m)){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return (int)low;
    }
    
    private boolean validDivisionPossible(long maxPossibleSum, int[] nums, int m){
        
        int totalSubsetCount = 1;
        long totalRunningSum = 0;
        for(int num: nums){
            totalRunningSum += num;
            
            if(totalRunningSum > maxPossibleSum){
                totalRunningSum = 0;
                totalRunningSum += num;
                
                totalSubsetCount++;
                
                if(totalSubsetCount > m){
                    return false;
                }
            }
        }
        return true;
    }
}