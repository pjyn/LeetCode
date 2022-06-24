// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> arr = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            arr.add(p);
                        }
                    String line = sc.next();
                    Solution obj = new Solution();  
                    System.out.println(obj.wordBreak(line,arr));  
                    
                }
        }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static int wordBreak(String A, ArrayList<String> B )
    {
        int n = A.length();
        boolean[] dp = new boolean[n+1];
        dp[n] = true;
        
        for(int i=n-1; i>=0; i--){
            for(String s: B){
                if(i+s.length() <= n && A.substring(i, i+s.length()).equals(s) ){
                    dp[i] = dp[i + s.length()];
                }
                if(dp[i] == true){
                    break;
                }
            }
        }
        return dp[0] == true ? 1 : 0;
    }
}