class Solution {
    public int removePalindromeSub(String s) {
        
        if(s.isBlank())
            return 0;
        if(!isPalindrome(s)){
            return 2;
        }else{
            return 1;
        }
        
    }
    private boolean isPalindrome(String str){
        int l = 0;
        int r = str.length()-1;
        while(l < r){
            if(str.charAt(l) != str.charAt(r)){
                return false;
            }else{
                l++;
                r--;
            }
        }
        return true;
    }
}