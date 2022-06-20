class Solution {
    public int minimumLengthEncoding(String[] words) {
     
        // 3 == 
        /*
            'time''me''bell'
        */
        Set<String> hs = new HashSet<>(Arrays.asList(words));
        List<String> wordList = new ArrayList<>(hs);
        
        Set<String> duplicate = new HashSet<>();
        
        for(int i=0; i<wordList.size(); i++){
            for(int j=0; j<wordList.size(); j++){
                if(i != j){
                    if(wordList.get(i).endsWith(wordList.get(j))){
                        duplicate.add(wordList.get(j));
                    }
                }
            }
        }
        int cnt = 0;
        for(String s: hs){
            if(!duplicate.contains(s)){
                cnt += s.length() + 1;
            }
        }
        return cnt;
    }
}