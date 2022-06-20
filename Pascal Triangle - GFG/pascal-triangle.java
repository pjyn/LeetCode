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
        
        ArrayList<Long> op = new ArrayList<>();
        op.add(1L);
        return get(n, op);
    }
    
    ArrayList<Long> get(int n, ArrayList<Long> op){
        if(n == 1)
            return op;
        else{
            ArrayList<Long> br = new ArrayList<>();
            for(int i=0, j=1; i<op.size()-1 && j<op.size(); i++, j++){
                br.add( (op.get(i) + op.get(j))%1000000007);
            }
            br.add(0, 1L);
            br.add(1L);
            op = br;
            return get(n-1, op);
        }
    }
}