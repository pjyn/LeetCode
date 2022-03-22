class Solution {
    public String getSmallestString(int n, int k) {
        
        char[] arr = new char[n];
        
        Arrays.fill(arr, 'a');
        /*
            ['a', 'a', 'a', 'a', 'a']
        */
        HashMap<Integer, Character> hm = new HashMap<>();
        int cnt = 1;
        
        for(char i='a'; i<='z'; i++){
            hm.put(cnt++, i);
        }
        
        int sum = n;
        if(sum == k){
            return String.valueOf(arr);
        }
        
        for(int i=n-1; i>=0; i--){
            int tmp = arr[i]-'a'+1;
            int left = k-sum+tmp;       // 27-3+1 = 25
            if(left <= 26){
                arr[i] = hm.get(left);        // 
                break;
            }else{
                // if(left-26)
                arr[i] = 'z';
                sum = sum - 1 + 26;
            }
            
        }
        return String.valueOf(arr);
        
    }
}