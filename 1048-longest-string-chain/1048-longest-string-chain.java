class Solution {
    public int longestStrChain(String[] words) {
     
        Arrays.sort(words, (a, b)-> a.length()-b.length());
        Map<String, Integer> hm = new HashMap<>();
        int ans = 0;
        
        for(String word: words)   {
            int longestSubstring = 0;
            for(int i=0; i<word.length(); i++){
                String tmp = word.substring(0, i) + word.substring(i+1);
                
                longestSubstring = Math.max(longestSubstring, hm.getOrDefault(tmp, 0)+1);
            }
            hm.put(word, longestSubstring);
            ans = Math.max(ans, longestSubstring);
        }
        return ans;
    }
}