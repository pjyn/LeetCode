// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int n = Integer.parseInt(read.readLine());
            
            

            Solution ob = new Solution();
            
            System.out.println(ob.lookandsay(n));
        }
    } 
} // } Driver Code Ends


//User function Template for Java

class Solution{
    static String lookandsay(int n) {
        
        if(n == 1)
            return "1";
            
        StringBuilder sb = new StringBuilder();
        String s = lookandsay(n-1) + " ";     // 5, 4, 3, 2, 1
        
        for(int i=0, count=1; i<s.length()-1; i++, count++){
            if(s.charAt(i+1) != s.charAt(i)){
                sb.append(count).append(s.charAt(i));
                count = 0;
            }
        }
        return sb.toString();
    }
}
