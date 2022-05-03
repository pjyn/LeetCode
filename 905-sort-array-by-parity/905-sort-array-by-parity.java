class Solution {
    public int[] sortArrayByParity(int[] nums) {
        
        List<Integer> res = new ArrayList<>();
        
        for(int i: nums){
            if(i%2 == 0){
                res.add(0, i);
            }else{
                res.add(i);
            }
        }
        int[] re = res.stream().mapToInt(i->i).toArray();
        return re;
    }
}