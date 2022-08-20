class Solution {
    List<List<String>> rt;
    public List<List<String>> partition(String s) {
        
        rt = new ArrayList<>();
        rec(0, new ArrayList<>(), s);
        return rt;
    }
    
    private void rec(int index, List<String> curr, String s){
        
        if(index == s.length()){
            rt.add(new ArrayList<>(curr));
            return ;
        }
        
        for(int i=index; i<s.length(); i++){
            if(isPalindrome(s, index, i)){
                curr.add(s.substring(index, i+1));
                rec(i+1, curr, s);
                curr.remove(curr.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int l, int r){
        
        while(l <= r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}