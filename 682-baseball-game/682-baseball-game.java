class Solution {
    public int calPoints(String[] ops) {
        
        Stack<Integer> st = new Stack<>();
        
        for(String s: ops){
            
            if(s.equals("+")){
                // LinkedList
                if(!st.isEmpty()){
                    int first = Integer.valueOf(st.pop());
                    int second = Integer.valueOf(st.pop());
                    int sum = first+second;
                    st.push(second);
                    st.push(first);
                    st.push(sum);    
                }
                
            }else if(s.equals("D")){
                if(!st.isEmpty()){
                    int top = Integer.valueOf(st.peek());
                    st.push(top*2);    
                }
                
            }else if(s.equals("C")){
                if(!st.isEmpty())
                    st.pop();
            }else{
                int ml = Integer.valueOf(s);
                st.push(ml);
            }
        }
        
        int res = 0;
        while(!st.isEmpty()){
            int tr = st.pop();
            System.out.println(tr);
            res += tr;
        }
        return res;
    }
}