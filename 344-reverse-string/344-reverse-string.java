class Solution {
    public void reverseString(char[] s) {
        
        /*
            [h, e, l, l, o]
            
            [o, l, l, e, h]
        */
        String str = String.valueOf(s); // "hello"
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        
        str = sb.reverse().toString();   // "olleh"
        int cnt = 0;
        for(char c: str.toCharArray()){
            s[cnt++] = c;
        }
    }
}