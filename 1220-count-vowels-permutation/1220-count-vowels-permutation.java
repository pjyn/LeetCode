class Solution {
    HashMap<String, Long> hm = new HashMap<>();
    int MOD = 1000000007;
    public int countVowelPermutation(int n) {
        
        long total = 0;
        char[] ch = new char[] {'a', 'e', 'i', 'o', 'u'};
        for(char c: ch){
            total = (total + helper(n-1, c)) % MOD;
        }
        return (int)total;
    }
    
    private long helper(int remainingChar, char prevChar){
        
        String key = remainingChar + "" + prevChar;
        if(remainingChar == 0){
            return 1;
        }
        if(hm.containsKey(key)){
            return hm.get(key);
        }
        long total = 0;
        switch(prevChar){
            case 'a': total = (helper(remainingChar-1, 'e')) % MOD;
                break;
            case 'e': total = (helper(remainingChar-1, 'a') + helper(remainingChar-1, 'i')) % MOD;
                break;
            case 'i': total = (helper(remainingChar-1, 'a') + helper(remainingChar-1, 'e') + helper(remainingChar-1, 'o') + helper(remainingChar-1, 'u')) % MOD;
                break;
            case 'o': total = (helper(remainingChar-1, 'i') + helper(remainingChar-1, 'u')) % MOD;
                break;
            case 'u': total = helper(remainingChar-1, 'a');
                break;
        }
        hm.put(key, total);
        return total;
    }
}