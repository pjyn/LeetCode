class Solution {
    public int numUniqueEmails(String[] emails) {
        
        Set<String> hs = new HashSet<>();
        
        for(String email: emails){
            String[] part = email.split("@");
            String[] l = part[0].split("\\+");
            hs.add(l[0].replace(".", "") + "@" + part[1]);
        }
        return hs.size();
    }
}