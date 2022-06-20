// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            ArrayList<Long> ans = new Solution().nthRowOfPascalTriangle(n);
            printAns(ans);
        }
    }
    public static void printAns(ArrayList<Long> ans) {
        for (Long x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    ArrayList<Long> nthRowOfPascalTriangle(int n) {
        
        ArrayList<ArrayList<Long>> res = new ArrayList<>();
        
        if(n == 0){
            return new ArrayList<Long>();
        }
            
        ArrayList<Long> firstRow = new ArrayList<>();
        firstRow.add(1L);
        res.add(firstRow);
        
        for(int i=1; i<n; i++){
            ArrayList<Long> tmp = res.get(i-1);
            ArrayList<Long> row = new ArrayList<>();
            
            for(int j=1; j<i; j++){
                row.add( (tmp.get(j-1)+tmp.get(j)) % 1000000007 );
            }
            row.add(0, 1L);
            row.add(1L);
            res.add(row);
        }
        return res.get(n-1);
    }
}