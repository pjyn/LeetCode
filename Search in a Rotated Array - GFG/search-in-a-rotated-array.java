// { Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0)
        {
            int n = sc.nextInt();
            int A[] = new int[n];
            
            for (int i = 0;i < n;i++)
            {
                A[i] = sc.nextInt();
            }
            int key = sc.nextInt();
            
            System.out.println(new Solution().search(A, 0, n - 1, key));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    int search(int A[], int l, int h, int key)
    {
        if(A == null || A.length == 0)
            return -1;
        
        // sorting the array properly
        while(l < h){
            int mid = l+(h-l) / 2;
            if(A[mid] > A[h]){
                l=mid+1;
            }else{
                h=mid;
            }
        }
        
        int start = l;
        l = 0;
        h = A.length-1;
        
        if(key >= A[start] && key <= A[h]){
            l = start;
        }else{
            h = start;
        }
        
        while(l <= h){
            int mid = l+ (h-l)/2;
            if(A[mid] == key){
                return mid;
            }else if(A[mid] < key){
                l = mid+1;
            }else{
                h = mid-1;
            }
        }
        return -1;
    }
}