class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        
        // dcba abcd
        // 
        
        int n = words.length;
        List<List<Integer>> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<words.length; i++){
            
            map.put(words[i], i);       // abcd -> 0
                                        // dcba -> 1
                                        // lls-> 2
        }
        // 1. Empty
        if(map.containsKey("")){
            int index = map.get("");
            for(int i=0; i<n; i++){
                if(i != index && isPalindrome(words[i])){
                    res.add(Arrays.asList(i, index));
                    res.add(Arrays.asList(index, i));
                }
            }
        }
        // 2. Reflection
        for(int i=0; i<n; i++){
            String tmp = new StringBuilder(words[i]).reverse().toString();
            if(map.containsKey(tmp)){
                int reversedIndex = map.get(tmp);
                if(reversedIndex != i)      //reversedIndex != null && 
                    res.add(Arrays.asList(i, reversedIndex));
            }
        }
        
        // 3. tricky        put '-' in each substring 
        for(int i=0; i<n; i++){
            String curr = words[i];
            for(int j=1; j<curr.length(); j++){
                String left = curr.substring(0, j);
                String right = curr.substring(j);
                if(isPalindrome(left)){
                    String t = new StringBuilder(right).reverse().toString();
                    if(map.containsKey(t)){
                        res.add(Arrays.asList(map.get(t), i));
                    }
                }
                if(isPalindrome(right)){
                    String t = new StringBuilder(left).reverse().toString();
                    if(map.containsKey(t)){
                        res.add(Arrays.asList(i, map.get(t)));
                    }
                }
            }
        }
        return res;
    }
    
    private boolean isPalindrome(String str){
        int l = 0;
        int h = str.length()-1;
        
        while(l < h){
            if(str.charAt(l++) != str.charAt(h--)){
                return false;
            }
        }
        return true;
    }
}