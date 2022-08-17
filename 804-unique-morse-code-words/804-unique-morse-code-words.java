class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        
        
        String[] rt = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        char ch = 'a';
        
        HashMap<Character, String> hm = new HashMap<>();
        
        for(int i=0; i<26; i++){
            hm.put(ch, rt[i]);
            ch++;
        }
        
        /*
            a-> '.--.'
            b-> '-.._'
            c-> '.--.'
        */
        Set<String> hs = new HashSet<>();
        StringBuilder sb;
        
        for(String str: words){
            // "gin"
             sb = new StringBuilder();
            for(char c: str.toCharArray()){
                sb.append(hm.get(c));
            }
            hs.add(sb.toString());
        }
        return hs.size();
    }
}