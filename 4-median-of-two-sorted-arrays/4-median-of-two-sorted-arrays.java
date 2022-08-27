class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
     
        ArrayList<Integer> mixed = new ArrayList<>();
        
        for(int i: nums1){
            mixed.add(i);
        }
        for(int i: nums2){
            mixed.add(i);
        }
        
        Collections.sort(mixed);
        double ans = 0;
            
        int size = mixed.size();        
        
        if(size%2 == 0){        
            // 4 / 2 => 2       
            ans = ( mixed.get(size/2 - 1) + mixed.get(size/2) ) / 2.0;            // 2 + 3
            
            return ans;
        }else{
            ans = ( mixed.get(size/2)  );
            return ans;
        }
    }
}