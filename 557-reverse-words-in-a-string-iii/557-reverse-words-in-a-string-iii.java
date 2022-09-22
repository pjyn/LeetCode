class Solution {
    public String reverseWords(String s) {
        
        String[] str = s.split(" ");
        
        // ["lets", "take", "leetcode", "contest"]
        
        for(int i=0; i<str.length; i++){
            // 'lets'
            str[i] = new StringBuilder(str[i]).reverse().toString();        // ["stel", "ekat", "edoCteeL"];
        }
        
        StringBuilder ans = new StringBuilder();
        for(String ele: str){
            ans.append(ele + " ");
        }
        
        return ans.toString().trim();
    }
}