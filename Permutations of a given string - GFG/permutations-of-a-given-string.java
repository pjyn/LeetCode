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
        
        // boolean[] vis = new boolean[26];
        
        rec(0, S.toCharArray());        // ['A', 'B', 'C']
        Collections.sort(res);  
        return res;
    }
    private void rec(int index, char[] str){
        if(index >= str.length){
            String tmp = String.valueOf(str);
            if(!res.contains(tmp))
                res.add(tmp);
            return ;
        }
        
        for(int i=0; i<str.length; i++){
            swap(index, i, str);
            rec(index+1, str);
            swap(index, i, str);
        }
    }
    private void swap(int a, int b, char[] str){
        char tmp = str[a];
        str[a] = str[b];
        str[b] = tmp;
    }
}