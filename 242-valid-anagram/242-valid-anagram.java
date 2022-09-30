class Solution {
    public boolean isAnagram(String s, String t) {
        
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        String one = String.valueOf(arr1);
        String two = String.valueOf(arr2);
        
        if(one.equals(two)){
            return true;
        }
        return false;
    }
}