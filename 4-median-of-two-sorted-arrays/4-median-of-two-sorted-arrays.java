class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length < nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        int low=0, high = n2*2;
        
        while(low <= high){
            int cut2 = (low + high) / 2;
            int cut1 = n1 + n2 - cut2;
            
            double l1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[(cut1-1)/2];
            double l2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[(cut2-1)/2];
            double r1 = (cut1 == n1*2) ? Integer.MAX_VALUE : nums1[(cut1)/2];
            double r2 = (cut2 == n2*2) ? Integer.MAX_VALUE : nums2[(cut2)/2];
            
            if(l1 > r2){
                low = cut2+1;
            }else if(l2 > r1){
                high = cut2-1;
            }else{
                return (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
            }
        }
        return -1;
    }
}