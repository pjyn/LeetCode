class Solution {
    public boolean hasAllCodes(String s, int k) {
        
        HashSet<String> hs = new HashSet<>();
        for(int i=0; i<s.length()-k+1; i++){
            String tmp = s.substring(i, i+k);
            hs.add(tmp);
        }
        
        return hs.size() == Math.pow(2, k);
    }
}