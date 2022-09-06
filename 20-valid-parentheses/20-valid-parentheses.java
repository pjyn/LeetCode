class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> st = new Stack<>();
        
        if(s.length()%2 != 0)
            return false;
        
        for(char ch: s.toCharArray()){
            
            if(ch == ')' && !st.isEmpty() && st.peek() == '('){
                st.pop();
            }else if(ch == '}' && !st.isEmpty() && st.peek() == '{'){
                st.pop();
            }else if(ch == ']' && !st.isEmpty() && st.peek() == '['){
                st.pop();
            }else{
                st.push(ch);
            }
        }
        return st.isEmpty();
    }
}