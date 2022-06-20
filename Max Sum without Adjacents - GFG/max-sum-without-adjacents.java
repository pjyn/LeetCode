// { Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    int findMaxSum(int arr[], int n) {
        // code here
        int[] dp = new int[n];
        
        rec(arr, n-1, dp);
        return dp[n-1];
    }
    private int rec(int[] arr, int i, int[] dp){
        if(i < 0){
            return 0;
        }
        
        if(dp[i] != 0){
            return dp[i];
        }
        
        int op1 = arr[i] + rec(arr, i-2, dp);
        int op2 = rec(arr, i-1, dp) ;
        return dp[i] = Math.max(op1, op2);
        
    }
}