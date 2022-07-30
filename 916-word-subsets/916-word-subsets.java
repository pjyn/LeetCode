class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        
        int[] maxB = new int[26];
        
        for(String b: B){
            int[] f = new int[26];
            for(char c: b.toCharArray()){
                f[c-'a']++;
            }
            for(int i=0; i<26; i++){
                maxB[i] = Math.max(maxB[i], f[i]);
            }
        }
        
        List<String> res = new ArrayList<>();
        
        for(String a: A){
            int[] f = new int[26];
            for(char c: a.toCharArray()){
                f[c-'a']++;
            }
            if(isUniversal(f, maxB)){
                res.add(a);
            }
        }
        return res;
    }
    
    private boolean isUniversal(int[] f, int[] t){
        for(int i=0; i<f.length; i++){
            if(f[i] < t[i])
                return false;
        }
        return true;
    }
}