class Solution {
    public int maxProduct(String[] words) {
     
        int max = 0;
        
        for(int i=0; i<words.length-1; i++){
            HashSet<Character> hs = new HashSet<>();
            
            char[] ar = words[i].toCharArray(); // 
            // [a, b, c, w]
            for(char p: ar){
                hs.add(p);
            }
            for(int j=i+1; j<words.length; j++){
                char[] tmp = words[j].toCharArray();
                // [b, a, z]
                boolean isOk = true;
                for(char p: tmp){
                    if(hs.contains(p)){
                        isOk = false;
                        break;
                    }
                }
                if(isOk){
                    max = Math.max(max, ar.length*tmp.length);
                }
            }
        }
        return max;
    }
}