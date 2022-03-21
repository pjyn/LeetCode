class Solution {
    public List<Integer> partitionLabels(String s) {
        
        List<Integer> output_arr = new ArrayList<>();
        
        int[] last_index = new int[26];
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            last_index[ch-'a'] = i;
        }
        
        /*
            []
        */
        int start = 0;
        int end = 0;
        
        for(int i=0; i<s.length(); i++){
            end = Math.max(end, last_index[s.charAt(i)-'a']);
            if(end == i){
                output_arr.add(end-start+1);
                start = end+1;
            }
        }
        return output_arr;
    }
}