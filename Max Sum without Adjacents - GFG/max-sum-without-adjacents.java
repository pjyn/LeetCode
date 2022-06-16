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
        /*
            [5, 5, 10, 100, 10, 5]
            
        */
        int[] dp = new int[n];
        rec(arr, n-1, dp);
        return dp[n-1];
    }
    private int rec(int[] arr, int index, int[] dp){
        
        if(index < 0){
            return 0;
        }
        if(dp[index] != 0){
            return dp[index];
        }
        int op1 = arr[index] + rec(arr, index-2, dp);
        int op2 = rec(arr, index-1, dp);
        return dp[index] = Math.max(op1, op2);
    }
}