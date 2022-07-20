class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        
        HashMap<Character, Queue<String>> hm = new HashMap<>(); // stroing their indexes
        int ans = 0;
        
        for(int i=0; i<s.length(); i++){
            hm.putIfAbsent(s.charAt(i), new LinkedList<>());  // 
        }
        
        for(String word: words){
            char startChar = word.charAt(0);
            if(hm.containsKey(startChar)){
                hm.get(startChar).offer(word);
            }
        }
        
        for(int i=0; i<s.length(); i++){
            // "abcde"
            char startChar = s.charAt(i);
            Queue<String> q = hm.get(startChar);
            int size = q.size();
            while(size-- > 0){
                String str = q.poll();
                if(str.substring(1).length() == 0){
                    ans++;
                }else{
                    if(hm.containsKey(str.charAt(1))){
                        hm.get(str.charAt(1)).add(str.substring(1));
                    }
                }
            }
        }
        /*
            a-> a, abc, acd
            b-> 1
            c-> 2
            d-> 3
            e-> 4
        */
        return ans;
    }
}