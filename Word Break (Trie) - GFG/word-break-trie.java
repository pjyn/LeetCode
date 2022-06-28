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
        //code here
        boolean[] dp = new boolean[A.length()+1];
        dp[A.length()] = true;
        
        for(int i=A.length()-1; i>=0; i--){
            for(String word: B){
                if(i+word.length() <= A.length() && A.substring(i, i+word.length()).equals(word)){
                    dp[i] = dp[i+word.length()];
                }
                if(dp[i])
                    break;
            }
        }
        return dp[0] == false ? 0 : 1;
    }
}