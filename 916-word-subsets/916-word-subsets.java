class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        
        int[] maxB = new int[26];
        
        for(int i=0; i<B.length; i++){
            
            String r = B[i];
            int[] freq = new int[26];
            for(char c: r.toCharArray()){
                freq[c-'a']++;
            }
            
            for(int j=0; j<26; j++){
                maxB[j] = Math.max(maxB[j], freq[j]);
            }
        }
        
        List<String> res = new ArrayList<>();
        
        for(int i=0; i<A.length; i++){
            
            String rt = A[i];
            int[] freq = new int[26];
            for(char c: rt.toCharArray()){
                freq[c-'a']++;
            }
            
            if(isUniversal(freq, maxB)){
                res.add(rt);
            }
        }
        return res;
    }
    
    private boolean isUniversal(int[] freq, int[] max){
        
        for(int i=0; i<26; i++){
            if(freq[i] < max[i]){
                return false;
            }
        }
        return true;
    }
}