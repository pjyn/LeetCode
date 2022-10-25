class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        
        /*
            string array,
        */
        StringBuilder sb = new StringBuilder();
        for(String rt: word1){
            sb.append(rt);
        }
        
        StringBuilder sb1 = new StringBuilder();
        for(String s: word2){
            sb1.append(s);
        }
        
        return sb.toString().equals(sb1.toString());
    }
}