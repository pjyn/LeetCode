class Solution {
    public String breakPalindrome(String palindrome) {
        
        char[] cStr = palindrome.toCharArray();
        
        if(cStr.length < 2){
            return "";
        }
        
        for(int i=0; i<cStr.length/2; i++){
            if(cStr[i] != 'a'){
                cStr[i] = 'a';
                return String.valueOf(cStr);
            }
        }
        
        cStr[cStr.length-1] = 'b';
        return String.valueOf(cStr);
    }
}