class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
     
        int[] clone1 = new int[m+n];
        
        int ptr1 = 0;
        int ptr2 = 0;
            
        int cnt = 0;
        while(ptr1 < m && ptr2 < n){
            if(nums1[ptr1] < nums2[ptr2]){
                clone1[cnt++] = nums1[ptr1++];
            }else{
                clone1[cnt++] = nums2[ptr2++];
            }
        }
        if(ptr1 < m){
            while(ptr1 < m){
                clone1[cnt++] = nums1[ptr1++];
            }
        }
        if(ptr2 < n){
            while(ptr2 < n){
                clone1[cnt++] = nums2[ptr2++];
            }
        }
        
        for(int i=0; i<m+n; i++){
            nums1[i] = clone1[i];
        }
    }
}