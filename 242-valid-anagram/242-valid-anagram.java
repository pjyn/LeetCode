class Solution {
    public boolean isAnagram(String s, String t) {
     
        char[] ar = s.toCharArray();
        char[] we = t.toCharArray();
        
        Arrays.sort(ar);
        Arrays.sort(we);
        
        if ( String.valueOf(ar).equals( String.valueOf(we) ) ){
            return true;
        }else{
            return false;
        }
    }
}