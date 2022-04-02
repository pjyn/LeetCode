class Solution {
    public boolean validPalindrome(String s) {
     
        if(isPalindrome(s)){
            return true;
        }else{
            return false;
        }
    }
    private boolean isPalindrome(String str){
        
        int left = 0;
        int right = str.length()-1;
        int cnt = 0;
        
        while(left < right){
            
            if(str.charAt(left) != str.charAt(right)){
                return checkPalindrome(str, left, right-1) || checkPalindrome(str, left+1, right);
            }
            left++;
            right--;
        }
        return true;
    }
    private boolean checkPalindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}