class Solution {
    public int numUniqueEmails(String[] emails) {
        
        Set<String> hs = new HashSet<>();
        
        for(String email: emails){
            String updatedEmail = get(email);
            hs.add(updatedEmail);
        }
        return hs.size();
    }
    
    private String get(String email){
        String localName = "";
        
        int i=0;
        while(i < email.length() && email.charAt(i) != '@'){
            if(email.charAt(i) == '.'){
                i++;
            }else if(email.charAt(i) == '+'){
                while(i < email.length() && email.charAt(i) != '@'){
                    i++;
                }
            }else{
                localName += email.charAt(i);
                i++;
            }
        }
        i++;
        String domain = "";
        while(i < email.length()){
            domain += email.charAt(i);
            i++;
        }
        return localName + '@' + domain;
    }
}