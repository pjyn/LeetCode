class Solution {
    public int minMoves2(int[] nums) {
        
        List<Integer> r = new ArrayList<>();
        
        for(int i: nums){
            r.add(i);
        }
        
        Collections.sort(r);
        // [1, 2, 3]
        int size = r.size();
        int median = r.get(size/2);
        
        int ans = 0;
        for(int i: r){
            ans += Math.abs(i-median);
        }
        return ans;
    }
}