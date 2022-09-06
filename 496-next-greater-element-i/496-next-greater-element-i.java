class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
     
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int ele: nums2){
            while(!st.isEmpty() && st.peek() < ele){
                hm.put(st.pop(), ele)    ;
            }
            st.push(ele);
        }
        
        for(int i=0; i<nums1.length; i++){
            
            nums1[i] = hm.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }
}