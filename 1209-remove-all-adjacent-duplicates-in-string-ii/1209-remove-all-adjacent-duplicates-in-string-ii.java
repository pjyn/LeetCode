class Solution {
    public String removeDuplicates(String s, int k) {
        
        Stack<Pair<Character, Integer>> st = new Stack<>();
        
        for(char c: s.toCharArray()){
            if(st.isEmpty() || st.peek().getKey() != c){
                st.push(new Pair<>(c, 1));
            }else{
                // matching
                Pair<Character, Integer> head = st.pop();
                st.push(new Pair<>(c, head.getValue()+1));
                if(st.peek().getValue() == k){
                    st.pop();
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            Pair<Character, Integer> he = st.pop();
            int cnt = he.getValue();
            while(cnt-->0){
                sb.append(he.getKey());
            }
        }
        return sb.reverse().toString();
    }
}