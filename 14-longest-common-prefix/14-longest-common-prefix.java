class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if(strs == null || strs.length == 0)
            return "";
        String pre = strs[0];   //flower, 
        int i = 1;
        while(i < strs.length){
            while(strs[i].indexOf(pre) != 0){
                pre = pre.substring(0, pre.length()-1);
            }
            i++;
        }
        // 25,00,000/-
        return pre;
    }
}