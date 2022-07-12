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
    public List<String> find_permutation(String S) {
        List<String> res = new ArrayList<>();
        
        rec(S.toCharArray(), 0, res);
        Collections.sort(res);
        return res;
    }
    private void rec(char[] S, int idx, List<String> res){
        
        if(idx >= S.length){
            String tmp = String.valueOf(S);
            if(!res.contains(tmp)){
                res.add(tmp);
            }
            return ;
        }
        
        for(int i=0; i<S.length; i++){
            swap(S, idx, i);
            rec(S, idx+1, res);
            swap(S, idx, i);
        }
        
    }
    private void swap(char[] s, int idx, int i){
        char tmp = s[idx];
        s[idx] = s[i];
        s[i] = tmp;
    }
}