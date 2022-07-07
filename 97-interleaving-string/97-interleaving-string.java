class Solution {
    Set<Integer> vis;
    public boolean isInterleave(String s1, String s2, String s3) {
     
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();
        
        if(l1+l2 != l3){
            return false;
        }
        
        vis = new HashSet<>();
        
        return rec(s1, 0, s2, 0, s3, 0);
    }
    
    private boolean rec(String s1, int i, String s2, int j, String s3, int k){
        int hash = j*s3.length() + i;
        if(vis.contains(hash))
            return false;
        
        if(i == s1.length())
            return s2.substring(j).equals(s3.substring(k));
        
        if(j == s2.length())
            return s1.substring(i).equals(s3.substring(k));
        
        if(s3.charAt(k) == s1.charAt(i) && rec(s1, i+1, s2, j, s3, k+1) || s3.charAt(k) == s2.charAt(j) && rec(s1, i, s2, j+1, s3, k+1))
            return true;
        
        vis.add(hash);
        return false;
    }
}