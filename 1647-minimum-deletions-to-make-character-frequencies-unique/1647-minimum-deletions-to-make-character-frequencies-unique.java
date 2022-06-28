class Solution {
    public int minDeletions(String s) {
        
        int[] ch = new int[26];
        
        for(char c: s.toCharArray()){
            
            ch[c-'a']++;
        }
        
        Set<Integer> used = new HashSet<>();
        
        int res = 0;
        for(int i=0; i<26; i++){
            while(ch[i] > 0 && !used.add(ch[i])){
                ch[i]--;
                res++;
            }
        }
        return res;
    }
}