// { Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} // } Driver Code Ends




class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int a[])
    {
        int[][] dp = new int[a.length][a.length];
        return rec(-1, 0, a, dp);
    }
    
    private static int rec(int prev, int curr, int nums[], int dp[][]){
        if(curr == nums.length)
            return 0;
            
        if(prev != -1 && dp[prev][curr] != 0){
            return dp[prev][curr];
        }
        
        int op1 = 0;
        if(prev == -1 || nums[prev] < nums[curr]){
            op1 = 1 + rec(curr, curr+1, nums, dp);
        }
        int op2 = rec(prev, curr+1, nums, dp);
        
        if(prev != -1){
            dp[prev][curr] = Math.max(op1, op2);
        }
        return Math.max(op1, op2);
    }
} 