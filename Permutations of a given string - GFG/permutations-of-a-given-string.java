// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();
                        
        }
	}
}

// } Driver Code Ends


class Solution {
    ArrayList<String> res;
    public List<String> find_permutation(String S) {
        // Code here
        res = new ArrayList<String>();
        rec(0, S.toCharArray());
        Collections.sort(res);
        return res;
    }   
    private void rec(int index, char[] S){       // [0, "", ['A', 'B', 'C']]
        
        if(index >= S.length){
            String str = String.valueOf(S);
            if(!res.contains(str))
                res.add(str);
            return ;
        }
        
        for(int i=0; i<S.length; i++){
            swap(index, i, S);   // [A, A]
            rec(index+1, S);
            swap(index, i, S);
        }
    }
    private void swap(int a, int b, char[] S){
        char tmp = S[a];
        S[a] = S[b];
        S[b] = tmp;
    }
}